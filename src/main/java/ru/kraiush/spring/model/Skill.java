package ru.kraiush.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "skills")
@Data
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String SkillType;

    public Skill(Long id, String skillType) {
        this.id = id;
        SkillType = skillType;
    }

    @ManyToMany(mappedBy = "relatedSkills")
    List<Event> events;
}

