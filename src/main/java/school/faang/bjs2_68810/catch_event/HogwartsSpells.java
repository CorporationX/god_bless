package school.faang.bjs2_68810.catch_event;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellByIdMap = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByTypeMap = new HashMap<>();
    private int currentId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        currentId++;
        SpellEvent spellEvent = new SpellEvent(currentId, eventType, actionDescription);
        spellByIdMap.put(currentId, spellEvent);
        spellsByTypeMap.putIfAbsent(eventType, new ArrayList<>());
        spellsByTypeMap.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellByIdMap.get(id);
        if (spellEvent == null) {
            log.error("SpellEvent with id {} is not found", id);
            throw new SpellEventNotFoundException("Exception: SpellEvent with id " + id + " is not found");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String spellEventType) {
        List<SpellEvent> spellEventList = spellsByTypeMap.get(spellEventType);
        if (spellEventList == null) {
            log.error("SpellEvents with type {} are not found", spellEventType);
            throw new SpellEventNotFoundException("Exception: SpellEvents with type "
                    + spellEventType + " are not found");
        }
        return spellEventList;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = getSpellEventById(id);

        spellByIdMap.remove(id);

        List<SpellEvent> spellEventsDefineType = spellsByTypeMap.get(spellEvent.getEventType());
        spellEventsDefineType.remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellByIdMap.entrySet()) {
            log.info(entry.getValue().toString());
        }
    }
}
