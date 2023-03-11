package cz.upce.cv01.dto;

import cz.upce.cv01.domain.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private String username;
    private String password;
    private Boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public AppUserDto(AppUser appUser) {
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.active = appUser.getActive();
        this.creationDate = appUser.getCreationDate();
        this.updateDate = appUser.getUpdateDate();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
