<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title>Felipe JR</title>
    <link rel="stylesheet" href="./assets/stylesheet/reset.css" />
    <link rel="stylesheet" href="./assets/stylesheet/style.css" />
</head>

<body>
    <div id="nav">
        Felipe Borges CRUD
    </div>
    <section id="table">
        <table id="myTable">
            <tr id="0">
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Sexo</th>
                <th>Telefone</th>
                <th>Cep</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>UF</th>
                <th>Editar</th>
                <th>Deletar</th>
            </tr>
            <tbody>
		<c:forEach var="pessoa" items="${lista_pessoas}">
			<tr>
			<td><c:out value="${pessoa.id}" /></td>
			<td><c:out value="${pessoa.nome}" /></td>
			<td><c:out value="${pessoa.email}" /></td>
			<td><c:out value="${pessoa.sexo}" /></td>
			<td><c:out value="${pessoa.celular}" /></td>
			<td><c:out value="${pessoa.cep}" /></td>
			<td><c:out value="${pessoa.endereco}" /></td>
			<td><c:out value="${pessoa.cidade}" /></td>
			<td><c:out value="${pessoa.bairro}" /></td>
			<td><c:out value="${pessoa.uf}" /></td>
			<td><a href="<%=request.getContextPath()%>/UsuarioEdit?id=<c:out value='${pessoa.id}' />">Editar</a></td>
			<td><a href="<%=request.getContextPath()%>/UsuarioDelete?id=<c:out value='${pessoa.id}' />">Deletar</a></td>
			</tr>
		</c:forEach>
		</tbody>
        </table>
    </section>
</body>
</html>