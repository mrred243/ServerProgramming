package fi.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository) {
	return (args) -> {
		
		Book b1= new Book("Harry Potter", "J.K Rowling", "0000-1", 2000, 30);
		Book b2= new Book("Conan", "Agasa", "0000-2", 1981, 10);
		
		brepository.save(b1);
		brepository.save(b2);


	};
	}

}
