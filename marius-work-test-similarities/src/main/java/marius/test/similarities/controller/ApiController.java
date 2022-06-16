package marius.test.similarities.controller;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import marius.test.similarities.entity.Const;
import marius.test.similarities.entity.Product;
import marius.test.similarities.services.GetDetails;
import marius.test.similarities.services.GetSimilar;
import marius.test.similarities.services.JsonStringToArray;
import marius.test.similarities.services.JsonStringToProduct;
import marius.test.similarities.services.SaveResponse;

@RestController
@ResponseBody
public class ApiController {

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<String> welcome() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome to my app\nPlease use http://localhost:5000/product/{productId}/similar to get similar products");
	}
	
	@GetMapping("/product/{productId}/similar")
	@ResponseBody
	public ResponseEntity<String> product(@PathVariable String productId){
		
		String response;
		GetSimilar similar = new GetSimilar();
		GetDetails details = new GetDetails();
		JsonStringToArray jsonStrArray = new JsonStringToArray();
		JsonStringToProduct jsonStrProduct = new JsonStringToProduct();
		ArrayList<String> similarsList = new ArrayList<String>();
		ArrayList<Product> similarProductsDetailsList = new ArrayList<Product>();
		ResponseEntity<String> respNOK = ResponseEntity.status(HttpStatus.NOT_FOUND)
			    .body(Const.ERROR_MESSAGE);
		SaveResponse saveRespose = new SaveResponse();

		//Read from http://localhost:3001/product/{productId}/similarids similar products with the id provided
		try {
			response = similar.getSimilar(productId);
			if(response.equals(Const.NOK_MESSAGE)) {
				//If we don't get similarities, we respond with code: 404 and description: Product Not found
				return respNOK;
			}else{
				//If we found similarities (code :'200'; description: OK; content: application/json), we search for then details for all the products id's we get from the response at http://localhost:3001/product/{productId}
				similarsList = jsonStrArray.jsonStrToArray(response);
				//loop between the similar products ids we have found 
				Integer[] similarsArray = similarsList.toArray(new Integer[0]);
				for(int i = 0; i < similarsArray.length; i++) {
					String id = similarsArray[i].toString();
					response = details.getDetails(id);
					if(!response.equals(Const.NOK_MESSAGE)) {
						//if we get a 404 response we do nothing and  pass to next id
						//if we get a 200 response we put the details into our object
						similarProductsDetailsList.add(jsonStrProduct.jsonStrToProduct(response));
					}
				}
				//when loop finish we show the object (if object empty we show code: 404 and description: Product Not found)
				return saveRespose.save(similarProductsDetailsList);
			}
		} catch (IOException e) {
			//If we don't get similarities, we respond with code: 404 and description: Product Not found
			if(e.getMessage().equals(Const.READ_TIMEOUT)) {
				return saveRespose.save(similarProductsDetailsList);
			}else {
				return respNOK;
			}
		}
	}
	
}
