package com.sapients.controller;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapients.domain.Product;

@RestController
public class ProductCatalogueServiceController {

	//private static Map<String, List<Product>> productDatabase = new HashMap<String, List<Product>>();
	private static List<Product> productList = new ArrayList<Product>();
	static {
		//productDatabase = new HashMap<String, List<Product>>();


		Product product = new Product("Nokia Mobile", "Mobile");
		Product product1=new Product("Xiomi M1 A1","Mobile");
		Product product2 = new Product("Sony Tv", "Television");
		Product product3=new Product("WhirlPool Refrigerator","Refrigerator");
		productList.add(product);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);

	}

	@RequestMapping(value = "/getProductDetailsByProductType/{productType}", method = RequestMethod.GET,produces = "application/json")
	public List<Product> getProducts(@PathVariable String productType) {
		List<Product> productList=new ArrayList<>();
		System.out.println("Getting Product details for " + productType);
       for(Product product:productList)
	   {
	   	if(product.getProductType().equalsIgnoreCase(productType))
		{
			productList.add(product);
		}
	   }
		return productList;
	}
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = "application/json" )
	public void addProducts(Product product) {

		productList.add(product);
	}
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE, consumes = "application/json" )
	public void deleteProducts(@PathVariable String productType) {

		List<Product> productList=new ArrayList<>();
		System.out.println("Getting Product details for " + productType);
		Iterator itr=productList.iterator();
		while(itr.hasNext()) {
			Product product= (Product) itr.next();
			if(product.getProductType().equalsIgnoreCase(productType))
			{
				itr.remove();
			}
		}

}
}

