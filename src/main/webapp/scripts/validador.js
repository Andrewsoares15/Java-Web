/**
 * Validação de formulário
 */
function validar(){
	const nome = document.querySelector(".caixa1").value
	const fone = document.querySelector(".caixa2").value
	if(nome === ""){
		alert("Preencha o campo nome")
		frmcontato.nome.focus()
		return false
	}
	else if(fone === ""){
		alert("Preencha o campo fone")
		frmcontato.fone.focus()
		return false
	}else{
		document.forms["frmcontato"].submit()
	}
}