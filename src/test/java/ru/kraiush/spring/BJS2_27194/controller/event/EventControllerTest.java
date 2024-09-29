package ru.kraiush.spring.BJS2_27194.controller.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kraiush.spring.BJS2_27194.dto.EventDto;
import ru.kraiush.spring.BJS2_27194.dto.SkillDto;
import ru.kraiush.spring.BJS2_27194.model.Event;
import ru.kraiush.spring.BJS2_27194.model.Skill;
import ru.kraiush.spring.BJS2_27194.util.MapperUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("EventController")
class EventControllerTest {

    @Test
    void checkConvertDtoToEntity() {
        EventDto eventDto = new EventDto();
        eventDto.setId(new Random().nextLong(1, 100));
        eventDto.setTitle(randomAlphabetic(7));

        eventDto.setStartDate(LocalDateTime.of(2024, Month.JANUARY, 1, 1, 30));

        eventDto.setEndDate(LocalDateTime.now());
        eventDto.setOwnerId(new Random().nextLong(1, 100));
        eventDto.setDescription(randomAlphabetic(10));
        eventDto.setLocation("London");
        eventDto.setMaxAttendees(99);

        List<SkillDto> listSkillDtos = new ArrayList<>();
        listSkillDtos.add(new SkillDto(111l, "abra"));
        listSkillDtos.add(new SkillDto(222l, "cada"));
        listSkillDtos.add(new SkillDto(333l, "bra"));
//        List<Skill> listSkills= MapperUtil.convertList(listSkillDtos, Skill.class);
        eventDto.setRelatedSkills(listSkillDtos);

        Event event = MapperUtil.convertClass(eventDto, Event.class);
        assertEquals(eventDto.getId(), event.getId());
        assertEquals(eventDto.getTitle(), event.getTitle());
        assertEquals(eventDto.getStartDate(), event.getStartDate());
        assertEquals(eventDto.getEndDate(), event.getEndDate());
        assertEquals(eventDto.getOwnerId(), event.getOwnerId());
        assertEquals(eventDto.getDescription(), event.getDescription());
        assertEquals(eventDto.getLocation(), event.getLocation());
        assertEquals(eventDto.getMaxAttendees(), event.getMaxAttendees());
        assertEquals(eventDto.getRelatedSkills().get(0).getId(), event.getRelatedSkills().get(0).getId());
        assertEquals(eventDto.getRelatedSkills().get(0).getSkillType(), event.getRelatedSkills().get(0).getSkillType());
        assertEquals(eventDto.getRelatedSkills().get(1).getId(), event.getRelatedSkills().get(1).getId());
        assertEquals(eventDto.getRelatedSkills().get(1).getSkillType(), event.getRelatedSkills().get(1).getSkillType());
        assertEquals(eventDto.getRelatedSkills().get(2).getId(), event.getRelatedSkills().get(2).getId());
        assertEquals(eventDto.getRelatedSkills().get(2).getSkillType(), event.getRelatedSkills().get(2).getSkillType());
    }

    @Test
    void checkConvertEntityToDto() {
        Event event = new Event();
        event.setId(new Random().nextLong(1, 100));
        event.setTitle(randomAlphabetic(7));

        event.setStartDate(LocalDateTime.of(2024, Month.JANUARY, 1, 1, 30));

        event.setEndDate(LocalDateTime.now());
        event.setOwnerId(new Random().nextLong(1, 100));
        event.setDescription(randomAlphabetic(10));
        event.setLocation("London");
        event.setMaxAttendees(99);
        List<Skill> listSkills = new ArrayList<>();
        listSkills.add(new Skill(111l, "abra"));
        listSkills.add(new Skill(222l, "cada"));
        listSkills.add(new Skill(333l, "bra"));
        event.setRelatedSkills(listSkills);
        EventDto eventDto = MapperUtil.convertClass(event, EventDto.class);
        assertEquals(eventDto.getId(), event.getId());
        assertEquals(eventDto.getTitle(), event.getTitle());
        assertEquals(eventDto.getStartDate(), event.getStartDate());
        assertEquals(eventDto.getEndDate(), event.getEndDate());
        assertEquals(eventDto.getOwnerId(), event.getOwnerId());
        assertEquals(eventDto.getDescription(), event.getDescription());
        assertEquals(eventDto.getLocation(), event.getLocation());
        assertEquals(eventDto.getMaxAttendees(), event.getMaxAttendees());
        assertEquals(eventDto.getRelatedSkills().get(0).getId(), event.getRelatedSkills().get(0).getId());
        assertEquals(eventDto.getRelatedSkills().get(0).getSkillType(), event.getRelatedSkills().get(0).getSkillType());
        assertEquals(eventDto.getRelatedSkills().get(1).getId(), event.getRelatedSkills().get(1).getId());
        assertEquals(eventDto.getRelatedSkills().get(1).getSkillType(), event.getRelatedSkills().get(1).getSkillType());
        assertEquals(eventDto.getRelatedSkills().get(2).getId(), event.getRelatedSkills().get(2).getId());
        assertEquals(eventDto.getRelatedSkills().get(2).getSkillType(), event.getRelatedSkills().get(2).getSkillType());
    }
}