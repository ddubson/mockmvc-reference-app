package com.ddubson.api;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Alt2_BookControllerTest extends AbstractBookControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Override
	public MockMvc mockMvc() {
		return mockMvc;
	}
}
