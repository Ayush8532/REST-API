package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jpa.test.entities.Book;
@Component
public class BookService {

	public static List<Book>list=new ArrayList<>();
	static {
		list.add(new Book(1,"NN","BB"));
		list.add(new Book(2,"NNss","fsdBB"));
		list.add(new Book(3,"NrN","BBdsfs"));
	}
	
	public List<Book>getBook(){
		return list;
	}
	public Book getSingleBook(int id) {
		Book book=null;
		try {
			book =list.stream().filter(e->e.getId()==id).findFirst().get();			
		}catch(Exception e) {
			e.fillInStackTrace();
		}
			return book;
	}
	public Book addBook(Book b){
		list.add(b);
		return b;
	}
	
	public boolean deleteBook(int id) {
		return list.removeIf(book -> book.getId() == id);
	}
	public void updateBook(int id ,Book book) {
		list=list.stream().map(b->{
			if(b.getId()==id)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
