/**
 * confrmação de exclução
@author Andrew Soares 
 */
function confirmar(idcon){
	var resposta = confirm("Confirma a exclução desse contato? ")
	if(resposta === true){
		window.location.href = "delete?idcon=" + idcon
	}
}