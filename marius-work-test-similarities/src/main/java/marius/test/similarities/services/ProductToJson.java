package marius.test.similarities.services;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import marius.test.similarities.entity.Product;

public class ProductToJson {

	public String writeProductToJson(ArrayList<Product> productList) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(productList);
			return json;
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
