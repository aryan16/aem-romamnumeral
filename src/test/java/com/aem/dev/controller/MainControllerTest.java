package com.aem.dev.controller;

import com.aem.dev.exception.MainAppException;
import com.aem.dev.service.IntToRoman;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class MainControllerTest {

    private MockMvc mockMvc;
    private MainController mainController;

    @Before
    public void setUp() throws Exception {
        IntToRoman intToRoman = new IntToRoman();
        mainController = new MainController(intToRoman);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testMainController() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/romannumeral").param("query", "455")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input", Matchers.is("455")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.output", Matchers.is("CDLV")));
    }

    @Test
    public void testMainControllerExceptions() throws Exception {
        assertThrows(MainAppException.class, () -> mainController.romanToIntRequestHandler("123w"));
        assertThrows(MainAppException.class, () -> mainController.romanToIntRequestHandler("6000"));
    }
}
