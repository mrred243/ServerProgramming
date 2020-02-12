package fi.haagahelia.Bookstore.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
		

    @RequestMapping(value = {"/", "/booklist"})
	public String bookList (Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
    
    @RequestMapping(value = "/add")
    public String showAddBookForm(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book, Model model){
        brepository.save(book);
        model.addAttribute("books", brepository.findAll());
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.deleteById(bookId);
        return "redirect:../booklist";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("book", brepository.findById(id));
    	model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatebook(@PathVariable("id") Long bookId, @Valid Book book, Model model){
    	brepository.save(book);
        model.addAttribute("books", brepository.findAll());
        return "redirect:booklist";
    }   
}
