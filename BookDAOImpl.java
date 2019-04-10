package com.Metro.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.Metro.BookModel.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	 @Autowired
     HibernateTemplate temp;
	
	@Override
	public long save(Book book) {		
		 temp.save(book);
		 return book.getId();
	}

	@Override
	public Book getbook(long id) {		
		System.out.println("Id:-"+id);
		Book book=temp.get(Book.class,id);
		System.out.println("BookId:-"+book.getId());
		System.out.println("BookAuthor:-"+book.getAuthor());
		System.out.println("BookTitle:-"+book.getTitle());
		return book;

	}

	@Override
	public List<Book> getListBook() {
		List<Book> list=temp.loadAll(Book.class);
		System.out.println(list.size());
		return list;
	}

	@Override
	public void deletebook(long id) {
		Book book=temp.load(Book.class, id);
		temp.delete(book);
	}

	@Override
	public void updatebook(Book book, long id) {		
	Book book2=temp.load(Book.class, id);
	book2.setAuthor(book.getAuthor());
    book2.setTitle(book.getTitle());	
	temp.flush();		
	}

	
	
	
	
}
