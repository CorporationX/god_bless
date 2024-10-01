package ru.kraiush.spring.BJS2_27254.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kraiush.spring.BJS2_27254.model.TeamMember;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    @Query(
            value = "SELECT * FROM members m WHERE m.name = :item",
            nativeQuery = true)
    TeamMember findMemberByName(@Param("item") String name);
}
