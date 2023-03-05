package cz.upce.cv01.repository;

import cz.upce.cv01.domain.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

    List<AppUser> findAllByActiveEquals(boolean active);

    //@Query(value = "SELECT u FROM AppUser u WHERE u.roles = ")
    @Query(value = "SELECT DISTINCT user FROM AppUser user JOIN user.roles role WHERE role.name = ?1")
    List<AppUser> findAppUserByRoles(String role);

    List<AppUser> findAll();

}
