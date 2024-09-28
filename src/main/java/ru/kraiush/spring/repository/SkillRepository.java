package ru.kraiush.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kraiush.spring.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
