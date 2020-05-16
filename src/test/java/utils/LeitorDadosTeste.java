package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LeitorDadosTeste {
	static JSONParser parser = new JSONParser();
	public static JSONObject jsonObject;

	public static void main(String[] args) throws Exception {
		jsonObject = lerJson();
		System.out.println(jsonObject.get("url"));
		System.out.println(jsonObject.get("email"));
		System.out.println(jsonObject.get("senha"));

	}

	/**
	 * Metodo para LerJson
	 * 
	 * @return
	 * @throws IOException
	 * @throws org.json.simple.parser.ParseException
	 * @throws FileNotFoundException
	 */
	private static JSONObject lerJson()
			throws IOException, org.json.simple.parser.ParseException, FileNotFoundException {
		return (JSONObject) parser.parse(new FileReader("./src/test/resources/dadosTestes.json"));
	}

	/**
	 * Metodo para retornar um valor. A partir de uma chave. Ex: getData(usuario)=
	 * Retorno "teste@teste.com.br"
	 * 
	 * @param chave
	 * @return
	 */
	public String getData(String chave) {
		return (String) jsonObject.get(chave);
	}

}
