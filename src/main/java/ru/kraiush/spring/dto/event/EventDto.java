package ru.kraiush.spring.dto.event;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDto {

    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long ownerId;
    private String description;
    private String location;
    private int maxAttendees;
    private List<SkillDto> relatedSkills;

    public List<SkillDto> getRelatedSkills() {
        if (relatedSkills == null) {
            relatedSkills = new ArrayList<>();
        }
        return relatedSkills;
    }
}
