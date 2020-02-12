package fi.haagahelia.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	public Long categoryid;
	public String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getCategory() {
		return name;
	}
	public void setCategory(String name) {
		this.name = name;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setId(Long id) {
		this.categoryid = id;
	}
	
	public Category() {}
	public Category(String name) {
		super();
		this.name = name;
	}

	
	
	
}
