package com.ddubson.api;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class AbstractBookControllerTest {
	abstract public MockMvc mockMvc();

	@Test
	public void getAllBooks_shouldReturnAllBooks() throws Exception {
		mockMvc().perform(get("/books")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value("1"))
				.andExpect(jsonPath("$[0].name").value("Encyclopedia"))
				.andExpect(jsonPath("$[1].id").value("2"))
				.andExpect(jsonPath("$[1].name").value("Dictionary"));
	}

	@Test
	public void getBook_shouldReturnSingleBook() throws Exception {
		mockMvc().perform(get("/books/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andExpect(jsonPath("$.name").value("Encyclopedia"));
	}
}
