package ru.kraiush.spring.BJS2_27194.controller.event;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kraiush.spring.BJS2_27194.dto.EventDto;
import ru.kraiush.spring.BJS2_27194.model.Event;
import ru.kraiush.spring.BJS2_27194.service.event.EventService;
import ru.kraiush.spring.BJS2_27194.service.event.impl.EventServiceImpl;
import ru.kraiush.spring.BJS2_27194.util.MapperUtil;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private static Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventServiceImpl service;

    @GetMapping
    public ResponseEntity<List<EventDto>> findAll() {
        log.info("start load All events");
        List<Event> events = service.findAll();
        return new ResponseEntity<>(MapperUtil.convertList(events, EventDto.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        log.info("start creating event: ", eventDto);
        Event event = MapperUtil.convertClass(eventDto, Event.class);
        Event eventCreated = service.create(event);
        return new ResponseEntity<>(MapperUtil.convertClass(eventCreated, EventDto.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventDto> getEvent(@PathVariable("id") long id) {
        log.info("start load event by id: ", id);
        Event event = service.findById(id);
        return new ResponseEntity<>(MapperUtil.convertClass(event, EventDto.class), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateEvent(@RequestBody EventDto eventDto) {
        log.info("start update event: ", eventDto);
        Event event = MapperUtil.convertClass(eventDto, Event.class);
        service.update(event);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
