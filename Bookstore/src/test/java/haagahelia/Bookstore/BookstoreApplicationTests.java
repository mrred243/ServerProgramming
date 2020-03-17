package haagahelia.Bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.Bookstore.web.BookController;
import fi.haagahelia.Bookstore.web.UserDetailServiceImpl;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController controller;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
