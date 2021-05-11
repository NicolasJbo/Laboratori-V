package com.example.springRepaso.Controller;

import com.example.springRepaso.AbstractController;
import com.example.springRepaso.controller.PersonController;
import com.example.springRepaso.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;


import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = PersonController.class)
public class PersonacontrollerTest extends AbstractController {

    @MockBean
    private PersonService personService;

    @Test
    public  void getAllPerson() throws Exception {
        final ResultActions resultActions = givenController().perform(MockMvcRequestBuilders
                .get("/persona")
                 .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        assertEquals(HttpStatus.OK.value(), resultActions.andReturn().getResponse().getStatus());
    }


}
