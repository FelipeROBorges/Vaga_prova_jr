<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<script type="text/javascript">
	function validarEmail(input) {
		let validRegex = /\S+@\S+\.\S+/;
		;
		if (input.value.match(validRegex)) {
			return true;
		} else {
			alert("E-mail invalido!");
			return false;
		}
	}
	function mascararCep(cep){
	  if (!cep.value) return false;
	  cep.value = cep.value.replace(/\D/g,"")                
	  return cep.value = cep.value.replace(/^(\d{5})(\d)/,"$1-$2");
	}
	function validarUf(uf){
		uf= uf.toUpperCase();
		let ufRegex = /[AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO]/;
		if(ufRegex.test(uf)){
			return true;
		} else {
			alert("UF invalido!");
			return false;
		}
	}
	function senhaValida(senha) {
		let retorno = false;
		let letrasMaiusculas = /[A-Z]/;
		let letrasMinusculas = /[a-z]/;
		let numeros = /[0-9]/;
		let caracteresEspeciais = /[!|@|#|$|%|^|&|*|(|)|-|_]/;
		if (senha.length > 14) {
			return alert("Senha invalida! Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.");
		}
		if (senha.length < 8) {
			return alert("Senha invalida! Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.");
		}
		let auxMaiuscula = 0;
		let auxMinuscula = 0;
		let auxNumero = 0;
		let auxEspecial = 0;
		for (let i = 0; i < senha.length; i++) {
			if (letrasMaiusculas.test(senha[i]))
				auxMaiuscula++;
			else if (letrasMinusculas.test(senha[i]))
				auxMinuscula++;
			else if (numeros.test(senha[i]))
				auxNumero++;
			else if (caracteresEspeciais.test(senha[i]))
				auxEspecial++;
		}
		if (auxMaiuscula > 0) {
			if (auxMinuscula > 0) {
				if (auxNumero > 0) {
					if (auxEspecial) {
						return true;
					}
				}
			}
		}
		return alert("Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.");
	}
	function aplicarMascara(o, f) {
		setTimeout(function() {
			var v = mascararTelefone(o.value);
			if (v != o.value) {
				o.value = v;
			}
		}, 1);
	}

	function mascararTelefone(v) {
		if (!v) return "";
		let r = v.replace(/\D/g, "");
		r = r.replace(/^0/, "");
		if (r.length > 10) {
			r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
		} else if (r.length > 5) {
			r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
		} else if (r.length > 2) {
			r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
		} else {
			r = r.replace(/^(\d*)/, "($1");
		}
		return r;
	}
	function comparaSenhas(senha){
		if(senha == document.getElementById("senha").value){
			return true;
		}else{
			alert("As senhas não coincidem.");
		}
	}
</script>
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
								onkeypress="aplicarMascara(this, mascararTelefone);" onblur="aplicarMascara(this, mascararTelefone);" required>
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
								name="uf" id="uf" onblur="validarUf(this.value);" maxlength="2" required>
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control" placeholder="Senha" 
							value="<c:out value='${pessoa.senha}' />"
								id="senha" onblur="senhaValida(senha.value)" name="senha" required>
						</div>
						<div class="input-group form-group">
							<input type="password" class="form-control" placeholder="Confirmar Senha"
							value="<c:out value='${pessoa.senha}' />"
								id="confirmar" onblur="comparaSenhas(confirmar.value)" required>
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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
		
	</script>
</body>
<style>
@import url('https://fonts.googleapis.com/css?family=Numans');

html, body {
	background-image:
		url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	height: 100%;
	font-family: 'Numans', sans-serif;
}

.container {
	height: 100%;
	align-content: center;
}
#uf {
	text-transform: uppercase;
}

.card {
	height: 790px;
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
}

.social_icon span {
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
}

.social_icon span:hover {
	color: white;
	cursor: pointer;
}

.card-header h3 {
	color: white;
}

.social_icon {
	position: absolute;
	right: 20px;
	top: -45px;
}

.input-group-prepend span {
	width: 50px;
	background-color: #FFC312;
	color: black;
	border: 0 !important;
}

input:focus {
	outline: 0 0 0 0 !important;
	box-shadow: 0 0 0 0 !important;
}

.remember {
	color: white;
}

.remember input {
	width: 20px;
	height: 20px;
	margin-left: 15px;
	margin-right: 5px;
}

.login_btn {
	color: black;
	background-color: #FFC312;
	width: 100px;
}

.login_btn:hover {
	color: black;
	background-color: white;
}

.links {
	color: white;
}

.links a {
	margin-left: 4px;
}
</style>
</html>