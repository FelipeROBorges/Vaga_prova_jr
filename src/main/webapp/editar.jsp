<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	
	<script type="text/javascript" src="./assets/javascript/script.js"></script>
	<link rel="stylesheet" href="./assets/stylesheet/cad_edit_style.css" />
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Editar</h3>
				</div>
				<div class="card-body">
					<form action="UsuarioUpdate" method="POST">
						<div class="input-group form-group">
							<input type="text" id="id" class="form-control"
								placeholder="Id" name="id" value="<c:out value='${pessoa.id}' />" readonly>
						</div>
						<div class="input-group form-group">
							<input type="text" id="nome" class="form-control"
								placeholder="Nome" name="nome" value="<c:out value='${pessoa.nome}' />" required>
						</div>
						<div class="input-group form-group">
							<select class="form-control" name="sexo" required>
								<option value="M">Masculino</option>
								<option value="F">Feminino</option>
								<option value="undefined">Prefiro não especificar</option>
							</select>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="E-mail"
								id="email" value="<c:out value='${pessoa.email}' />" onblur="validarEmail(email)" name="email" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Celular"
								name="celular" id="celular" value="<c:out value='${pessoa.celular}' />"
								onkeypress="mascararTelefone(this);" onblur="mascararTelefone(this);" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Endereço"
								name="endereco" id="endereco" value="<c:out value='${pessoa.endereco}' />" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Cep"
								name="cep" id="cep" onkeypress="mascararCep(this);" maxlength="9"
								value="<c:out value='${pessoa.cep}' />" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Bairro"
								value="<c:out value='${pessoa.bairro}' />" name="bairro" id="bairro" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Cidade"
								value="<c:out value='${pessoa.cidade}' />" name="cidade" id="cidade" required>
						</div>
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="UF" 
							value="<c:out value='${pessoa.uf}' />"
								name="uf" id="uf" onblur="validarUf(this);" maxlength="2" required>
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control" placeholder="Senha" 
							value="<c:out value='${pessoa.senha}' />"
								id="senha" onblur="senhaValida(this)" name="senha" required>
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control" placeholder="Confirmar Senha"
							value="<c:out value='${pessoa.senha}' />"
								id="confirmar" onblur="comparaSenhas(this)" required>
						</div>
						<div class="form-group">
							<input type="submit" value="Salvar"
								class="btn float-right login_btn" >
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						<a href="./index.html">Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<style>
.card {
	height: 790px;
}
</style>
</html>