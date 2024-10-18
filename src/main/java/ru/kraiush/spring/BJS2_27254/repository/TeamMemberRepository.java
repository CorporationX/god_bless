package ru.kraiush.spring.BJS2_27254.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kraiush.spring.BJS2_27254.domain.model.TeamMember;

import java.util.Optional;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    Optional<TeamMember> findByName(String name);

    Optional<TeamMember> findByEmail(String email);

    @Transactional(readOnly = true)
    @Query(
            value = "SELECT m.role FROM members m WHERE m.id = :dummy",
            nativeQuery = true)
    String findRoleById(@Param("dummy") Long id);
}
