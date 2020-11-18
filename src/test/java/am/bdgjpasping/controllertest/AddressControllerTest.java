package am.bdgjpasping.controllertest;

import am.bdgjpasping.controller.AddressController;
import am.bdgjpasping.entity.AddressEntity;
import am.bdgjpasping.service.serviceimpl.AddressServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.jupiter.params.ParameterizedTest;

/**
 * Created by User on 15.11.2020.
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddressServiceImpl addressService;

    @Test
    public void whenValidInput_thenReturnes200() throws Exception {
        AddressEntity addressEntity = new AddressEntity("aa", "aaaa");
        mockMvc.perform(post("addresses")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(addressEntity)))
                .andExpect(status().isOk());

    }
}
//https://reflectoring.io/unit-testing-spring-boot/?fbclid=IwAR288wbTC4JZ3rdNyXjZM3Xzo-RAz3Ej9FztzuuqlBy15GGljS0s8b4WroA
//https://mkyong.com/spring-boot/spring-boot-junit-5-mockito/
//https://levelup.gitconnected.com/using-mockito-for-unit-testing-96a74f3ed2a5
//https://www.youtube.com/watch?v=eJzTQDqL3rc
//https://www.youtube.com/watch?v=qPDheVUyH9k