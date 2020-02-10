package com.example.demo;


import com.example.demo.bean.request.Message;
import com.example.demo.config.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DemoApplication.class})
public class JUnitControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void insertMessage() throws Exception {
        Message m1 = new Message(2, new BigDecimal("2.10"));
        mockMvc.perform(MockMvcRequestBuilders
                .post("/demo/message")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(m1)))
                .andExpect(MockMvcResultMatchers.status().isOk());


        Message m2 = new Message(3, new BigDecimal("2.101"));
        mockMvc.perform(MockMvcRequestBuilders
                .post("/demo/message")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(m2)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


        Message m3 = new Message(2, new BigDecimal("123452.10"));
        mockMvc.perform(MockMvcRequestBuilders
                .post("/demo/message")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(m3)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}