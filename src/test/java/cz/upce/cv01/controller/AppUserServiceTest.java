package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.util.Optional;

import static cz.upce.cv01.controller.Example.EXISTING;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserServiceTest {

    private AppUser existing = null;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

//    @BeforeEach
//    void setUp() {
//        Mockito.when(appUserRepository.findById(100L)).thenReturn(Optional.of(EXISTING));
//    }

    @BeforeEach
    void setUp() {
        existing = appUserRepository.save(EXISTING);
    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    @Test
    @Transactional
    void findById() {
        var actual = appUserService.findById(100L);
        assertEquals(existing, actual.get());
    }
}