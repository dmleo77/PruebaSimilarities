package marius.test.similarities.services;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import marius.test.similarities.entity.Product;
import marius.test.similarities.entity.Const;

public class SaveResponse {
	public ResponseEntity<String> save(ArrayList<Product> similarProductsDetailsList) {
		ResponseEntity<String> respNOK = ResponseEntity.status(HttpStatus.NOT_FOUND)
			    .body(Const.ERROR_MESSAGE);
		ProductToJson productToJson = new ProductToJson();
		
		if(similarProductsDetailsList.isEmpty()) {
			return respNOK;
		}else {
			ResponseEntity<String> respOK = ResponseEntity.status(HttpStatus.OK)
				    .header("Content-Type", "application/json")
				    .body(productToJson.writeProductToJson(similarProductsDetailsList));
			return respOK;
		}
	}
}
