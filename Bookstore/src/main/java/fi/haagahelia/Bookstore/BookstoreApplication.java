package fi.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;
import fi.haagahelia.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
	return (args) -> {
		
		Category c1 = new Category("Detective");
		Category c2 = new Category("Fantasy");
		
		crepository.save(c2);
		crepository.save(c1);
		
		
		Book b2= new Book("Conan", "Agasa", "0000-2", 1981, 10, c1 );
		Book b1= new Book("Harry Potter", "J.K Rowling", "0000-1", 2000, 30, c2);

		
		brepository.save(b1);
		brepository.save(b2);


	};
	}

}
