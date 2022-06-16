package marius.test.similarities.pruebas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import marius.test.similarities.entity.Product;
import marius.test.similarities.services.JsonStringToProduct;

public class TestJsonToProduct {
	
	Product test(String strJson) throws JsonMappingException, JsonProcessingException {
		JsonStringToProduct jsonStrProduct = new JsonStringToProduct();
		return jsonStrProduct.jsonStrToProduct(strJson);
	}
}
