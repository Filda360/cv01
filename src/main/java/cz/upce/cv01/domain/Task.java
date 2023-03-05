package cz.upce.cv01.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    private long id;
    @Column
    private String title;
    @Column
    private String description;

    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "idAuthor", insertable = false, updatable = false)
    private AppUser author;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }
}
