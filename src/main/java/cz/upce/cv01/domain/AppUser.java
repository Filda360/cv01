package cz.upce.cv01.domain;

import cz.upce.cv01.dto.AppUserResponseDtoV1;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

//validate -> validate schema
//update -> update schema
//create -> create schema a destroy prev. data
//create-drop -> drop schema at the end of session

@Data
@Entity
@Getter
@Setter
public class AppUser {
    @Id
    private Long id;

    @Column
    private String username;
    @Column
    private String  password;

    @Column
    private Boolean active;

    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "author")
    private Set<Task> tasks;

    @ManyToMany
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AppUser(String username, String password, Boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    public AppUser() {
    }

    public AppUser(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public AppUserResponseDtoV1 toDto(){
        return new AppUserResponseDtoV1(
                getUsername(),
                getPassword(),
                getActive(),
                getCreationDate(),
                getUpdateDate()
        );
    }
}
