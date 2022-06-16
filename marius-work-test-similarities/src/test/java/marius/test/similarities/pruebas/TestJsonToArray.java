package marius.test.similarities.pruebas;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import marius.test.similarities.services.JsonStringToArray;

public class TestJsonToArray {
	
	ArrayList<String> test(String strJson) throws JsonMappingException, JsonProcessingException {
		JsonStringToArray jsonStrArray = new JsonStringToArray();
		return jsonStrArray.jsonStrToArray(strJson);
	}
}
