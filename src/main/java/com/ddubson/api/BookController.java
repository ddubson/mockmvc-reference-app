package com.ddubson.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BookController {
	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/books")
	public ResponseEntity getAllBooks() {
		return ok(bookRepository.getAllBooks());
	}

	@GetMapping("/books/{id}")
	public ResponseEntity getBook(@PathVariable Long id) {
		return ok(bookRepository.getBookById(id));
	}
}

@Data
@AllArgsConstructor
@Builder
class Book {
	private Long id;
	private String name;
}
