package ru.kraiush.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kraiush.spring.model.Skill;

import java.util.Collection;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query(
            value = "SELECT * FROM skills s WHERE s.skill_type = :type",
            nativeQuery = true)
    Skill findSkillByType(@Param("type") String skill_type);
}
