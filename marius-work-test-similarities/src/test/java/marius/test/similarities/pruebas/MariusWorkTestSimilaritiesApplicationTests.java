package marius.test.similarities.pruebas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
class MariusWorkTestSimilaritiesApplicationTests {

	@Test
	void contextLoads() throws JsonMappingException, JsonProcessingException {
		TestJsonToArray testJson1 = new TestJsonToArray();
		System.out.println(testJson1.test("[\"1\",\"2\",\"3\"]").toString());
		TestJsonToProduct testJson2 = new TestJsonToProduct();
		System.out.println(testJson2.test("{\"id\":\"3\",\"name\":\"Blazer\",\"price\":29.99,\"availability\":false}").toString());
	}
}
