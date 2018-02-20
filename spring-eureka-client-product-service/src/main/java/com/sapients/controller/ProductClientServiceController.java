package com.sapients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sapients.domain.Product;
import java.util.List;

import java.util.Arrays;

@RestController
public class ProductClientServiceController {
	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	@RequestMapping(value = "/getProductDetailsByProductType/{productType}", method = RequestMethod.GET)
	public List<Product> getProducts(@PathVariable String productType) {

		Product[] product=restTemplate.getForObject("http:localhost:8761/product-service/getProductDetailsByProductType/{productType}",Product[].class);

		return Arrays.asList(product);

	}


	@RequestMapping(value = "/addProduct", method = RequestMethod.POST )
	public void addProducts(Product product) {

	   restTemplate.postForObject("http:localhost:8761/product-service/addProduct}",product,null);

	}
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE, consumes = "application/json" )
	public void deleteProducts(@PathVariable String productType) {
		restTemplate.delete("http:localhost:8761/product-service/deleteProduct/{productType}");
	}

	}


