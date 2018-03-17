package com.ddubson.api.mvc;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepository {
	private ImmutableMap<Long, Book> books = ImmutableMap
			.<Long, Book>builder()
			.put(1L, new Book(1L, "Encyclopedia"))
			.put(2L, new Book(2L, "Dictionary")).build();

	public List<Book> getAllBooks() {
		return books.values().asList();
	}

	public Book getBookById(Long id) {
		return books.get(id);
	}
}
