package cz.upce.cv01.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Role {
    @Id
    private long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    Set<AppUser> users;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }
}
