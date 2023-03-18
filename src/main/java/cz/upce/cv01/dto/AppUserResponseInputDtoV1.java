package cz.upce.cv01.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AppUserResponseInputDtoV1 {
    @NotNull
    @Size(min=1, max=255, message="required, not null, 1-255")
    private String username;
    private String password;
    private Boolean active;

    public AppUserResponseInputDtoV1(String username, String password, Boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
