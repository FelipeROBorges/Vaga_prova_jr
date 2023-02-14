package controllers;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDAO;
import model.Pessoa;

@WebServlet("/UsuarioDelete")
public class UsuarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UsuarioDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PessoaDAO.delete(id);
		List<Pessoa> pessoas = PessoaDAO.find("");
		request.setAttribute("lista_pessoas", pessoas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
		requestDispatcher.forward(request, response);
	}
}
