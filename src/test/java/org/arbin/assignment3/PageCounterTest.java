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

class PageCountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PageCounter pageCounter;

    @InjectMocks
    private PageCountController pageCountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pageCountController).build();
    }

    @Test
    void testGetCurrentCount() throws Exception {
        // Arrange
        when(pageCounter.getPageCount()).thenReturn(10);

        // Act & Assert
        mockMvc.perform(get("/api/currentcount"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));

        verify(pageCounter, times(1)).getPageCount();
    }
}
