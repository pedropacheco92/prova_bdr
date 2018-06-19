package com.bdr.locadora.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testLoadAll() throws Exception {
		this.mockMvc.perform(get("/v1/cars")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").exists());
	}

	@Test
	public void testLoad() throws Exception {
		this.mockMvc.perform(get("/v1/cars/1")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.model").value("Fiesta"))
				.andExpect(jsonPath("$.year").value(2015))
				.andExpect(jsonPath("$.color").value("BLACK"));
	}

	@Test
	public void testLoadFail() throws Exception {
		this.mockMvc.perform(get("/v1/cars/999")).andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$").doesNotExist());
	}

	@Test
	public void testCreate() throws Exception {
		this.mockMvc.perform(post("/v1/cars")
				.contentType(APPLICATION_JSON_UTF8_VALUE)
				.content("{\"id\":null,\"model\":\"Fiesta2\",\"year\":2015,\"color\":\"BLACK\"}"))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$.id").value(7))
				.andExpect(jsonPath("$.model").value("Fiesta2"))
				.andExpect(jsonPath("$.year").value(2015))
				.andExpect(jsonPath("$.color").value("BLACK"));
	}

	@Test
	public void testUpdate() throws Exception {
		this.mockMvc.perform(put("/v1/cars/1")
				.contentType(APPLICATION_JSON_UTF8_VALUE)
				.content("{\"id\":2,\"model\":\"Fiesta3\",\"year\":2015,\"color\":\"BLACK\"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$.id").value(2))
				.andExpect(jsonPath("$.model").value("Fiesta3"))
				.andExpect(jsonPath("$.year").value(2015))
				.andExpect(jsonPath("$.color").value("BLACK"));
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMvc.perform(delete("/v1/cars/1")).andDo(print())
				.andExpect(status().isNoContent())
				.andExpect(jsonPath("$").doesNotExist());
	}

}
