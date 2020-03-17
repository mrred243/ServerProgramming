package haagahelia.Bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	 @Autowired
	    private BookRepository repository;
	 
	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = repository.findByTitle("Conan");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("Conan");
	    }
	    
	    //Check if I can save a new book
	    @Test
	    public void createNewBook() {
	    	Book book = new Book("IT", "Stephene King", "987897", 1992, 17, new Category("Horror"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }  
	    
	    @Test
	    public void deleteBook() {
	    	List<Book> books = repository.findByTitle("Conan");
	    	assertThat(books).hasSize(1);
	    	repository.deleteById((long) 3);
	    	books = repository.findByTitle("Conan");
	    	assertThat(books).hasSize(0);
	    }
	    

	    }
