package com.alpha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.models.Book;
import com.alpha.repository.BookRepository;
import com.alpha.util.BookConstants;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> getBooksService(){
		return (List<Book>) repository.findAll();
	}
	
	public Book getBookByIDService(int id) {
		return repository.findById(id).get();
	}
	
	public int saveBookService(List<Book> newBook) {
		repository.saveAll(newBook);
		System.out.println("Records updated: " +newBook.size());
		return newBook.size();
	}
	
	public String deleteBookByIDService(int id) {
		String status = BookConstants.STATUS_PENDING;
		
		try {
			repository.deleteById(id);
			status = BookConstants.STATUS_SUCCESS;
		}catch(Exception e) {
			status = BookConstants.STATUS_FAILED;
			System.out.println("Exception in deleteBookByIDService() =====>" +e.getMessage());
		}
		
		return status;
	}

	public Book updateBookService(Book book) {
		Book existing = repository.findById(book.getId()).get();
		
		existing.setId(book.getId());
		existing.setTitle(book.getTitle());
		existing.setAuthor(book.getAuthor());
		existing.setDescription(book.getDescription());
		existing.setPrice(book.getPrice());
		
		return repository.save(existing);
		
	}

}
