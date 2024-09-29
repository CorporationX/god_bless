package ru.kraiush.spring.BJS2_27194.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Data  // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long ownerId;
    private String description;
    private String location;
    private int maxAttendees;

    @ManyToMany
    @JoinTable(
            name = "event_skill",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> relatedSkills;
}
