package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDAO;
import model.Pessoa;
import java.util.List;

@WebServlet("/UsuarioLogin")
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String admin = "";
		boolean validador = false;
	

		List<Pessoa> pessoas = PessoaDAO.find(email);
		if(pessoas.size() > 0) {
			if(pessoas.get(0).getSenha().equals(senha)) {
				validador = true;
				admin = pessoas.get(0).getAdmin();
				System.out.println("Validado com sucesso!");
			}
		}

		if(validador == true && admin != null && admin.equals("true")) {
			pessoas = PessoaDAO.find("");
			request.setAttribute("lista_pessoas", pessoas);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} else if(validador == true) {
			System.out.println("Usuario validado!");
			response.sendRedirect("./sucesso.html");
		}else {
			System.out.println("Usuario invalido!");
			response.sendRedirect("./usuarioInvalida.html"); 
		}
	}
}
