package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.time.LocalDateTime.now;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public Optional<AppUser> findById(final Long id){
        var result = appUserRepository.findById(id);
        return result;
        //return ResponseEntity.ok(toDto(result.get())); //ResponseEntity
    }

    public List<AppUser> findAllByActiveEquals(boolean b) {
        return appUserRepository.findAllByActiveEquals(true);
    }

    public Optional<AppUser> findAppUserById(long id){
        return appUserRepository.findAppUserById(id);
    }

    public List<AppUser> findAppUserByRoles(String role){
        return appUserRepository.findAppUserByRoles(role);
    }

    public AppUser create(final AppUser entity){
        entity.setId(new Random().nextLong());
        entity.setCreationDate(now());
        entity.setUpdateDate(now());
        return appUserRepository.save(entity);
    }

    public void deleteUser(long id){appUserRepository.deleteUser(id);}

    public AppUser updateUser(long id, AppUser newAppUser){
        AppUser old = appUserRepository.findAppUserById(id).get();
        old.setPassword(newAppUser.getPassword());
        old.setUsername(newAppUser.getUsername());
        old.setActive(newAppUser.getActive());
        appUserRepository.save(old);
        return old;
    }

}
