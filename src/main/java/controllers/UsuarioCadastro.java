package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDAO;
import model.Pessoa;

@WebServlet("/UsuarioCadastro")
public class UsuarioCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioCadastro() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pessoa pessoa = new Pessoa();
		List<Pessoa> pessoas = PessoaDAO.find(request.getParameter("email"));

		pessoa.setNome(request.getParameter("nome"));
		pessoa.setSexo(request.getParameter("sexo"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setCelular(request.getParameter("celular"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setCep(request.getParameter("cep"));
		pessoa.setBairro(request.getParameter("bairro"));
		pessoa.setCidade(request.getParameter("cidade"));
		pessoa.setUf(request.getParameter("uf"));
		pessoa.setEndereco(request.getParameter("endereco"));
		java.util.Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pessoa.setData_cadastro(sqlDate);


		if(pessoas.size() == 0) {
			PessoaDAO.create(pessoa);
			response.sendRedirect("./sucesso.html");
		} else {
			System.out.println("Email invalido!");
			response.sendRedirect("./index.html"); 
		}
	}
}
