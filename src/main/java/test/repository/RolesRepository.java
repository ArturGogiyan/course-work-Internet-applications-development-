package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import test.entities.RolesEntity;

import java.util.List;


public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
    List<RolesEntity> findByUserName(String username);

    @Transactional
    void deleteByUserName(String username);
}
