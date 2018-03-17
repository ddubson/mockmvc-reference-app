package com.ddubson.api;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BookController {
	private ImmutableMap<Long, Book> books = ImmutableMap
			.<Long, Book>builder()
			.put(1L, new Book(1L, "Encyclopedia"))
			.put(2L, new Book(2L, "Dictionary")).build();


	@GetMapping("/books")
	public ResponseEntity getAllBooks() {
		return ok(books.values().asList());
	}

	@GetMapping("/books/{id}")
	public ResponseEntity getBook(@PathVariable Long id) {
		return ok(books.get(id));
	}
}

@Data
@AllArgsConstructor
class Book {
	private Long id;
	private String name;
}
