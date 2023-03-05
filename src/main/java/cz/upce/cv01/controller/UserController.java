package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appUser")
public class UserController {
    private final AppUserRepository appUserRepository;

    public UserController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("")
    public List<AppUser> findAll() {
        return this.appUserRepository.findAllByActiveEquals(true);
    }

    @GetMapping("/query")
    public List<AppUser> findByRule(@RequestParam(name = "role") String message){
        return appUserRepository.findAppUserByRoles(message);
    }


}
