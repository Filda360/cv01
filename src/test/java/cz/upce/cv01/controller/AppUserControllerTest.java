package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static cz.upce.cv01.controller.Example.EXISTING;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppUserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void testGetExistingUser() throws Exception {
        // Vytvoříme uživatele s id=1 v databázi
        long userId = 1;
        createUser(userId);

        // Otestujeme endpoint pro existujícího uživatele s id=1
        mockMvc.perform(get("/api/v1/app-user/{id}", userId))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNonExistingUser() throws Exception {
        // Pokusíme se získat neexistujícího uživatele s id=1
        long userId = 1;
        mockMvc.perform(get("/api/v1/app-user/{id}", userId))
                .andExpect(status().isNotFound());
    }

    private void createUser(long userId) {
        // TODO: vytvořit uživatele s daným id v databázi
        AppUser newUser = new AppUser();
        newUser.setId(userId);
        appUserRepository.save(newUser);
    }
}