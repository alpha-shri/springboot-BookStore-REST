package com.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.models.Book;
import com.alpha.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
// Fetch list of all Books
	@GetMapping("/fetchAllBooks")
	public List<Book> getAllBookHandler(){
		
		return service.getBooksService();
	}
	
// Fetch book by ID
	@GetMapping("/getBook/{id}")
	public Book getBookByIDHandler(@PathVariable int id) {
		return service.getBookByIDService(id);
		
	}
	
// Save a Book to the Database
	@PostMapping("/saveBook")
	public int saveBookHandler(@RequestBody List<Book> book) {
		System.out.println("saveBookHandler Method BooK: " +book);
		return service.saveBookService(book);
	}
	
// Update a Book record
	@PutMapping("/updateBook")
	public Book updateBookHandler(@RequestBody Book book) {
		return service.updateBookService(book);
	}
	
// Delete a book by ID
	@DeleteMapping("/removeBook/{id}")
	public String removeBookHandler(@PathVariable int id) {
		return service.deleteBookByIDService(id);
	}
	

}
