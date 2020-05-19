package maps;

public class ResultadoDaBuscaMap {
	
	
/**
 * Metódo Cria xpath para validar se o produto esperado esta na tela
 * @param produto
 * @return
 */
	public String criaElementoResultadoDaBusca(String produto) {
		return "//span[contains(text(),'"+produto+"')]";
	}
	
	
	
	

}
