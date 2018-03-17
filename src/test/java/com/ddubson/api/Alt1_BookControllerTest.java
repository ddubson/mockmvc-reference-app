package com.ddubson.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class Alt1_BookControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAll_shouldReturnAllBooks() throws Exception {
		this.mockMvc.perform(get("/books")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value("1"))
				.andExpect(jsonPath("$[0].name").value("Encyclopedia"));
	}
}