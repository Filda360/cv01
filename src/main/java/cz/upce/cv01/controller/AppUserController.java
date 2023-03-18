package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.dto.AppUserResponseDtoV1;
import cz.upce.cv01.dto.AppUserResponseInputDtoV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-user")
public class AppUserController {
    //private final AppUserRepository appUserRepository;
    private final AppUserService appuserService;

    @Autowired
    public AppUserController(AppUserService appUserService){
        this.appuserService = appUserService;
        //this.appUserRepository = appUserRepository;
    }

    @GetMapping("")
    public List<AppUser> findAll() {
        return this.appuserService.findAllByActiveEquals(true);
    }

    @GetMapping("/findRole")
    public List<AppUser> findByRole(@RequestParam(name = "role") String message){
        return this.appuserService.findAppUserByRoles(message);
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity findAppUserById(@PathVariable long id) throws ResourceNotFoundException{
        var result = appuserService.findById(id);
        if(result.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.ok(toDto(result.get()));
    }

    @PostMapping("/new")
    public ResponseEntity create(@Valid @RequestBody AppUserResponseInputDtoV1 dto){
        var result = appuserService.create(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(result));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity replaceEmployee(@RequestBody AppUserResponseInputDtoV1 newAppUser, @PathVariable Long id) {
        var result = appuserService.updateUser(id, toEntity(newAppUser));
        return ResponseEntity.status(HttpStatus.OK).body(toDto(result));
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        appuserService.deleteUser(id);
    }


    private static AppUserResponseDtoV1 toDto(final AppUser appUser) {
        return new AppUserResponseDtoV1(appUser);
    }

    private static AppUser toEntity(final AppUserResponseInputDtoV1 dto){
        return new AppUser(dto.getUsername(), dto.getPassword(), dto.getActive());
    }

}
