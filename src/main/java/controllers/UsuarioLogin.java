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
		String pesquisa = request.getParameter("pesquisa");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		boolean validador = false;
		
		

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Pessoa> pessoas = PessoaDAO.find(pesquisa);
		String admin = "";
		for(int i = 0; i < pessoas.size(); i ++ ) {
			String pessoa_email = pessoas.get(i).getEmail();
			String pessoa_senha = pessoas.get(i).getSenha();
			if(pessoa_email.equals(email) && pessoa_senha.equals(senha)) {
				admin = pessoas.get(i).getAdmin();
				System.out.println("Validado com sucesso!");
				validador = true;
			}  
		}
		if(validador == true && admin != null && admin.equals("true")) {
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
