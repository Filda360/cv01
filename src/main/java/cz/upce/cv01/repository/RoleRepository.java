package cz.upce.cv01.repository;

import cz.upce.cv01.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    List<Role> findAll();
}
