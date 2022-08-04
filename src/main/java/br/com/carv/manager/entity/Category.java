package br.com.carv.manager.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

	@Column(nullable = false, length = 100)
    private String description;
	
	@OneToMany(mappedBy = "category")
	//@JsonBackReference
	@JsonManagedReference
	private List<Product> products;
    
    public Category() {

    }

    public Category(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Product> getProducts() {
    	return products;
    }
    
    public void setProducts(List<Product> products) {
    	this.products = products;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	@Override
    public String toString() {
    	return "[Category]\nDescription: " + getDescription();
    }


}
