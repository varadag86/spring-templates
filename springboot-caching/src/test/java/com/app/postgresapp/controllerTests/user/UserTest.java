package com.app.postgresapp.controllerTests.user;

import com.app.postgresapp.domain.User;
import com.app.postgresapp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setupTest() {
        User admin = new User();
        admin.setName("John Doe");
        admin.setExperience(14);
        admin.setEmailAddress("john.doe@test.com");
        this.userRepository.saveAndFlush(admin);

        User staff = new User();
        staff.setName("John Doe");
        staff.setExperience(14);
        staff.setEmailAddress("john.doe@test.com");
        this.userRepository.saveAndFlush(staff);
    }

    @AfterEach
    public void tearDown() {
        this.userRepository.deleteAll();
    }

    @Test
    void get_all_users() throws Exception {

        mockMvc.perform(get("/api/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().json("[{\"id\":1,\"name\":\"John Doe\",\"emailAddress\":\"john.doe@test.com\",\"experience\":14},{\"id\":2,\"name\":\"John Doe\",\"emailAddress\":\"john.doe@test.com\",\"experience\":14}]"));
    }
    
}
