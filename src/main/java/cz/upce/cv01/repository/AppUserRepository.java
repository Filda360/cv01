package cz.upce.cv01.repository;

import cz.upce.cv01.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

    List<AppUser> findAllByActiveEquals(boolean active);

    //@Query(value = "SELECT u FROM AppUser u WHERE u.roles = ")
    @Query(value = "SELECT DISTINCT user FROM AppUser user JOIN user.roles role WHERE role.name = ?1")
    List<AppUser> findAppUserByRoles(String role);

    @Query(value = "SELECT user FROM AppUser user WHERE user.id = ?1")
    Optional<AppUser> findAppUserById(long id);

    List<AppUser> findAll();
    @Modifying
    @Query(value="DELETE FROM AppUser user WHERE user.id = ?1")
    void deleteUser(long id);

}
