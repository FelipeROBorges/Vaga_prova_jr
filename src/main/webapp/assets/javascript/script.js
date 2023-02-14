//Função para adicionar uma nova linha na tabela
function addToTable() {

    //Definindo as variaveis e recebendo os dados
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let telefone = document.getElementById('telefone').value;
    let cep = document.getElementById('cep').value;
    let cidade = document.getElementById('cidade').value;
    let bairro = document.getElementById('bairro').value;
    let uf = document.getElementById('uf').value;
    let table = document.getElementById("myTable");

    let tableSize = table.rows.length; //Calculando o tamanho da Tabela
    let row = table.insertRow(tableSize); //Inserindo uma linha abaixo da Tabela
    let cell1 = row.insertCell(0); //Inserindo as celulas da linha
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);
    let cell6 = row.insertCell(5);
    let cell7 = row.insertCell(6);
    let cell8 = row.insertCell(7);
    let cell9 = row.insertCell(8);
    row.id = tableSize; //Adicionando o id no elemento a ser criado

    //Criando o codigo do botão para remover a linha
    let btnCode = "<button class='remove-btn' onclick='removeToTable(this)'>Remover</button>";

    //Preenchendo as celulas da linha
    cell1.innerHTML = tableSize;
    cell2.innerHTML = name;
    cell3.innerHTML = email;
    cell4.innerHTML = telefone;
    cell5.innerHTML = cep;
    cell6.innerHTML = cidade;
    cell7.innerHTML = bairro;
    cell8.innerHTML = uf;
    cell9.innerHTML = btnCode;

    //Limpando os campos de inserção de dados
    document.getElementById('name').value = "";
    document.getElementById('email').value = "";
    document.getElementById('telefone').value = "";
    document.getElementById('cep').value = "";
    document.getElementById('cidade').value = "";
    document.getElementById('bairro').value = "";
    document.getElementById('uf').value = "";


    //Retornando 'false' para impedir o reload da pagina
    return false;
}

//Função para remover uma linha
function removeToTable(id){

    let row = id.parentNode.parentNode.id; //Pegando o id do avô do botão
    row = document.getElementById(row); //Recebendo o elemento da linha pelo ID
    row.parentNode.removeChild(row); //Removendo a linha

    //Retornando 'false' para impedir o reload da pagina
    return false;
}