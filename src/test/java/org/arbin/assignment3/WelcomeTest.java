package org.arbin.assignment3;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

class WelcomeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PageCounter pageCounter;

    @InjectMocks
    private WelcomeController welcomeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
    }

    @Test
    void testWelcome() throws Exception {
        // Arrange
        when(pageCounter.getPageCount()).thenReturn(5);

        // Act & Assert
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("pageCount", 5));

        // Verify interactions
        verify(pageCounter, times(1)).increment();
        verify(pageCounter, times(1)).getPageCount();
    }
}
