function validarEmail(email) {
  let email_regex = /\S+@\S+\.\S+/;
  if (email_regex.test(email.value)) {
    return true;
  } else{
    alert("E-mail invalido!");
    return false;
  }
}

function mascararCep(cep) {
  cep.value = cep.value.replace(/\D/g, "");
  return cep.value = cep.value.replace(/^(\d{5})(\d)/, "$1-$2");
}

function validarUf(uf) {
  let ufRegex = /^(\s*(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)?)$/;
  if (ufRegex.test(uf.value.toUpperCase())) {
    return true;
  } else{
    alert("UF invalido!");
    return false;
  }
}

function senhaValida(senha) {
  let senha_valeu = senha.value;
  let letrasMaiusculas = /[A-Z]/;
  let letrasMinusculas = /[a-z]/;
  let numeros = /[0-9]/;
  let caracteresEspeciais = /[!|@|#|$|%|^|&|*|(|)|-|_]/;
  let auxMaiuscula = 0;
  let auxMinuscula = 0;
  let auxNumero = 0;
  let auxEspecial = 0;

  if (senha_valeu.length > 14){
    alert("Senha invalida! Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.");
    return false;
  }

  if (senha_valeu.length < 8){
    alert("Senha invalida! Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.");
    return false;
  }

  for (let i = 0; i < senha_valeu.length; i++) {
    if (letrasMaiusculas.test(senha_valeu[i]))
      auxMaiuscula++;
    else if (letrasMinusculas.test(senha_valeu[i]))
      auxMinuscula++;
    else if (numeros.test(senha_valeu[i]))
      auxNumero++;
    else if (caracteresEspeciais.test(senha_valeu[i]))
      auxEspecial++;
  }
  if (auxMaiuscula > 0) {
    if (auxMinuscula > 0) {
      if (auxNumero > 0) {
        if (auxEspecial > 0) {
          return true;
        }
      }
    }
  }
  alert("Senhas devem conter entre 8-14 caracteres e ao menos uma letra, número e caractere especial.")
  return false;
}

function mascararTelefone(telefone) {
  let r = telefone.value.replace(/\D/g, "");
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
  return telefone.value = r;
}

function comparaSenhas(senha) {
  if (senha.value == document.getElementById("senha").value) {
    return true;
  } else{
    alert("As senhas não coincidem.");
    return false;
  }
}

function validarForm() {

  const email = document.getElementById("email");
  const uf = document.getElementById("uf");
  const senha = document.getElementById("senha");
  const comparaSenhas = document.getElementById("confirmar");

  let validarForm = validarEmail(email) &&
    validarUf(uf) &&
    senhaValida(senha) &&
    comparaSenhas(comparaSenhas);

  return validarForm;
}