package com.Metro.Service;

import java.util.List;

import com.Metro.BookModel.Book;


public interface BookService {
	
	long save(Book book);
	Book getbook(long id);
	List<Book> getListBook();
	void deletebook(long  id);
	void updatebook(Book book,long id);
	
}
