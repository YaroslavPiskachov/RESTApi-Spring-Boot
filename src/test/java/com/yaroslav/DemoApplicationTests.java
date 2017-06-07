package com.yaroslav;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	@Test
	public void verifyAllUsersList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}


	@Test
	public void verifyUserById() throws Exception {
		mockMvc.perform(get("/get/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.phone").exists())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Yaroslav"))
				.andExpect(jsonPath("$.phone").value("09582735782"))
				.andDo(print());
	}

	@Test
	public void verifyAddUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"Vladislav\", \"phone\" : \"09678432892\" }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.phone").exists())
				.andExpect(jsonPath("$.name").value("Vladislav"))
				.andExpect(jsonPath("$.phone").value("09678432892"))
				.andDo(print());
	}

	@Test
	public void verifyUpdateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\" : \"3\",\"name\" : \"Nastya\", \"phone\" : \"09678372892\" }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.phone").exists())
				.andExpect(jsonPath("$.id").value("3"))
				.andExpect(jsonPath("$.name").value("Nastya"))
				.andExpect(jsonPath("$.phone").value("09678372892"))
				.andDo(print());
	}

	@Test
	public void verifyDeleteUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/delete/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
