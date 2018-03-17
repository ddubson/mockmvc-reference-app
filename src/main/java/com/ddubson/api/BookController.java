package com.ddubson.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.collect.ImmutableList.of;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BookController {
	@GetMapping("/books")
	public ResponseEntity getAllBooks() {
		return ok(of(new Book(1L, "Encyclopedia")));
	}
}

@Data
@AllArgsConstructor
class Book {
	private Long id;
	private String name;
}
