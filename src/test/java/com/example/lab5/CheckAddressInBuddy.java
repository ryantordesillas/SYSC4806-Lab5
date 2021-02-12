package com.example.lab5;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CheckAddressInBuddy {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/buddyInfoes/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("12 Address Rd")));
        this.mockMvc.perform(get("/buddyInfoes/2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("84 That Way")));
        this.mockMvc.perform(get("/buddyInfoes/3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("48 Gold Drive")));
    }
}
