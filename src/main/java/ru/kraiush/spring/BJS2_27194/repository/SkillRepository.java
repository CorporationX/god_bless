package ru.kraiush.spring.BJS2_27194.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kraiush.spring.BJS2_27194.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query(
            value = "SELECT * FROM skills s WHERE s.skill_type = :type",
            nativeQuery = true)
    Skill findSkillByType(@Param("type") String skill_type);
}
