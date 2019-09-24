package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category c1 = new Category ("Crime");
			Category c2 = new Category ("Novel");

			
			crepository.save(c1);
			crepository.save(c2);

			Book b1 = new Book ("Juha", "React", 50, 22222, 2006, crepository.findByName("Crime").get(0) );
			
			repository.save(b1);
		};
	}
		
	
}
