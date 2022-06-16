package marius.test.similarities.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import marius.test.similarities.entity.Product;

public class JsonStringToProduct {
	

	public Product jsonStrToProduct(String jsonString) throws JsonMappingException, JsonProcessingException  {
	    
		final ObjectMapper objectMapper = new ObjectMapper();
	    Product product = objectMapper.readValue(jsonString, Product.class);
	    return product;
	}
}
