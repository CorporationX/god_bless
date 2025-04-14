package school.faang.bjs2_68810.catch_event;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class HogwartsSpells {
    private final Map<UUID, SpellEvent> spellByIdMap = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByTypeMap = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellByIdMap.put(spellEvent.getId(), spellEvent);
        spellsByTypeMap.putIfAbsent(eventType, new ArrayList<>());
        spellsByTypeMap.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(UUID id) {
        SpellEvent spellEvent = spellByIdMap.get(id);
        if (spellEvent == null) {
            log.error("SpellEvent with id {} is not found", id);
            throw new SpellEventNotFoundException("Exception: SpellEvent with id " + id + " is not found");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(EventType spellEventType) {
        List<SpellEvent> spellEventList = spellsByTypeMap.get(spellEventType);
        if (spellEventList == null) {
            log.error("SpellEvents with type {} are not found", spellEventType);
            throw new SpellEventNotFoundException("Exception: SpellEvents with type "
                    + spellEventType + " are not found");
        }
        return spellEventList;
    }

    public void deleteSpellEvent(UUID id) {
        SpellEvent spellEvent = spellByIdMap.remove(id);
        if (spellEvent == null) {
            log.error("SpellEvent with id {} is not found", id);
            throw new SpellEventNotFoundException("Exception: SpellEvent with id " + id + " is not found");
        }
        List<SpellEvent> spellEventsDefineType = spellsByTypeMap.get(spellEvent.getEventType());
        spellEventsDefineType.remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<UUID, SpellEvent> entry : spellByIdMap.entrySet()) {
            log.info(entry.getValue().toString());
        }
    }
}
