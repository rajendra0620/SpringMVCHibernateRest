package com.Metro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Metro.BookModel.Book;
import com.Metro.Service.BookService;

@RestController
@RequestMapping("/Metro")
public class BookController {
	
	@Autowired
	BookService service;
	
	
	
	@PostMapping("/book")
	public ResponseEntity<String> save(@RequestBody Book book){		
		long l=service.save(book);
		return ResponseEntity.ok().body("Book added sucessfully:-"+l);		
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id){		
		Book book=service.getbook(id);
		return ResponseEntity.ok().body(book);		
	}
	
	@GetMapping("/bookall")
	public ResponseEntity<List<Book>> getAll(){		
		List<Book> book=service.getListBook();
		return ResponseEntity.ok().body(book);		
	}
		
	@DeleteMapping("/book/delete/{id}")
	public ResponseEntity<String> deletebook(@PathVariable("id") long id){
		service.deletebook(id);
		return ResponseEntity.ok().body("Book hab been Delete Succesfully");
	}
	
	@PutMapping("/book/update/{id}")
     public ResponseEntity<String> updatebook(@PathVariable("id") long id,@RequestBody Book book){
		service.updatebook(book, id);
		return ResponseEntity.ok().body("Update Succesfully");
	}
	
}
