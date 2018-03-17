package com.ddubson.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class Alt1_BookControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookRepository bookRepository;

	@Test
	public void getAllBooks_shouldReturnAllBooks() throws Exception {
		when(bookRepository
				.getAllBooks())
				.thenReturn(
						asList(
								Book.builder().id(1L).name("Encyclopedia").build(),
								Book.builder().id(2L).name("Dictionary").build()
						)
				);
		mockMvc.perform(get("/books")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value("1"))
				.andExpect(jsonPath("$[0].name").value("Encyclopedia"))
				.andExpect(jsonPath("$[1].id").value("2"))
				.andExpect(jsonPath("$[1].name").value("Dictionary"));
	}

	@Test
	public void getBook_shouldReturnSingleBook() throws Exception {
		when(bookRepository
				.getBookById(1L))
				.thenReturn(
						Book.builder().id(1L).name("Encyclopedia").build()
				);
		mockMvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andExpect(jsonPath("$.name").value("Encyclopedia"));
	}
}