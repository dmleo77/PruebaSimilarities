package marius.test.similarities.services;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStringToArray {
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> jsonStrToArray(String jsonString) throws JsonMappingException, JsonProcessingException  {
		
	    final ObjectMapper objectMapper = new ObjectMapper();
	    ArrayList<String> stringArray = objectMapper.readValue(jsonString, ArrayList.class);
	    return stringArray;
	}
}
