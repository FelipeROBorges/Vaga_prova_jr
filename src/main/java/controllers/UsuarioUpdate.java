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

@WebServlet("/UsuarioUpdate")
public class UsuarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		
		Pessoa pessoa = new Pessoa( id,  nome,  sexo,  email,  celular,  senha,
				 cep,  endereco,  bairro,  cidade,  uf);
		PessoaDAO.update(pessoa);			
		List<Pessoa> pessoas = PessoaDAO.find("");
		request.setAttribute("lista_pessoas", pessoas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
		requestDispatcher.forward(request, response);
	}
}
