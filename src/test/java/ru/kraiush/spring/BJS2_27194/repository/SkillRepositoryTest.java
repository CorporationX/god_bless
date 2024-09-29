package ru.kraiush.spring.BJS2_27194.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import ru.kraiush.spring.BJS2_27194.model.Skill;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
class SkillRepositoryTest {

    @Autowired
    SkillRepository skillRepository;

    @Test
    @Sql("/scripts/INIT_EVENT_SKILLS.sql")
    void shouldReturnSkills() {
        List<Skill> skills = skillRepository.findAll();
        assertEquals(3, skills.size());
    }

    @Test
    @Sql("/scripts/INIT_EVENT_SKILLS.sql")
    void shouldReturnSkillByType() {
        Skill skill = skillRepository.findSkillByType("wizard");
        assertNotNull(skill);
    }
}