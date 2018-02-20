package com.sapients.domain;

public class Product {
	private String name;
	private String productType;

	
	public Product(String name, String itemType) {
		this.name = name;
		this.productType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String className) {
		this.productType = productType;
	}
}
