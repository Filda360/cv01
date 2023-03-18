package cz.upce.cv01.repository;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.domain.Role;
import cz.upce.cv01.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findAll();

//    @Query(value = "SELECT task FROM Task task WHERE task.author.id = ?1")
    List<Task> findByAuthor(AppUser appUser);
}
