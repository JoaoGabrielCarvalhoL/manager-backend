package br.com.carv.manager.entity;

import java.math.BigDecimal;

public class ProductBuilder {

	private Product product;

	public ProductBuilder() {
		product = new Product();
	}

	public ProductBuilder builder() {
		return new ProductBuilder();
	}

	public ProductBuilder productName(String productName) {
		this.product.setProductName(productName);
		return this;
	}

	public ProductBuilder amount(Integer amount) {
		this.product.setAmount(amount);
		return this;
	}

	public ProductBuilder unitPrice(BigDecimal unitPrice) {
		this.product.setUnitPrice(unitPrice);
		return this;
	}
	
	public Product build() {
		return this.product;
	}
}
