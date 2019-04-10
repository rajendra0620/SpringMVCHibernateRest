package com.Metro.DAO;

import java.util.List;

import com.Metro.BookModel.Book;

public interface BookDAO {
	
	long save(Book book);
	Book getbook(long id);
	List<Book> getListBook();
	void deletebook(long  id);
	void updatebook(Book book,long id);
	
	
}
