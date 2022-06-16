package marius.test.similarities.services;

import java.io.IOException;

public class GetSimilar {

    public String getSimilar(String id) throws IOException {
    	String jsonString;
    	String url = "http://localhost:3001/product/" + id + "/similarids";
    	HttpGet obj = new HttpGet();
    	jsonString = obj.getJson(url);
    	return jsonString;
    }

}
