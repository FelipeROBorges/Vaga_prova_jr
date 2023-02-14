package model;

import java.sql.Date;

public class Pessoa {
	private int id;
	private String nome;
	private String sexo;
	private String email;
	private String celular;
	private String senha;
	private Date data_cadastro;
	private String cep;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private String admin;
	
	
	public Pessoa() {
	}
	
	public Pessoa(int id, String nome, String sexo, String email, String celular, String senha,
			String cep, String endereco, String bairro, String cidade, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.celular = celular;
		this.senha = senha;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id +", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", celular=" + celular + ", senha="
				+ senha + ", cep=" + cep + ", bairro="+ bairro + ", cidade=" + cidade + ", uf="+ uf +", data_cadastro=" + data_cadastro + "]";
	}
	
}
