package marius.test.similarities.services;

import java.io.IOException;

public class GetDetails {
	
    public String getDetails(String id) throws IOException {
    	String jsonString;
    	String url = "http://localhost:3001/product/" + id;
    	HttpGet obj = new HttpGet();
    	jsonString = obj.getJson(url);
    	return jsonString;
    }
}
