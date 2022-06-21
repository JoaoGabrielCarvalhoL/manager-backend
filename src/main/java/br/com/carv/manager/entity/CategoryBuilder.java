package br.com.carv.manager.entity;

public class CategoryBuilder {

	private Category category;
	
	public CategoryBuilder() {
		category = new Category();
	}
	
	public static CategoryBuilder builder() {
		return new CategoryBuilder();
	}
	
	public CategoryBuilder description(String description) {
		category.setDescription(description);
		return this;
	}
	
	public Category build() {
		return this.category;
	}
}
