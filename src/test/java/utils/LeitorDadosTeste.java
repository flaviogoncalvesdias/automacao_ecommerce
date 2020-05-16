package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeitorDadosTeste {
	public static JSONParser parser = new JSONParser();
	public JSONObject jsonObject;

	
	public LeitorDadosTeste() {
		try {
			jsonObject = lerJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
