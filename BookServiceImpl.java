package com.Metro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Metro.BookModel.Book;
import com.Metro.DAO.BookDAOImpl;
@Service

public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAOImpl dao;
	
	@Override
	public long save(Book book) {		
		return dao.save(book);
	}

	@Override
	public Book getbook(long id) {		
		return dao.getbook(id);
	}

	@Override
	public List<Book> getListBook() {
		return dao.getListBook();
	}

	@Override
	 @Transactional
	public void deletebook(long id) {
		dao.deletebook(id);
	}

	@Override
	 @Transactional
	public void updatebook(Book book, long id) {
		dao.updatebook(book, id);
	}

}
