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

@WebServlet("/UsuarioEdit")
public class UsuarioEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa pessoa = PessoaDAO.findByPk(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("pessoa", pessoa);
		dispatcher.forward(request, response);
	}
}
