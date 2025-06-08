package school.faang.bjs279736;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int coutId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = coutId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public String getSpellEventById(int id) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getKey() == id) {
                log.info("Нашли заклинание по Id");
                return entry.getValue().getAction();
            }
        }
        return null;
    }

    public List<String> getSpellEventsByType(String eventType) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            if (entry.getKey().equals(eventType)) {
                for (SpellEvent list : entry.getValue()) {
                    result.add(list.getAction());
                }
                log.info("Нашли заклинане");
                return result;
            }
        }
        if (result == null){
            log.error("Заклинание не найдено");
        }
        return null;
    }

    public void deleteSpellEvent(int id) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getKey() == id) {
                spellById.remove(entry.getKey());
            }
        }
    }

    public void printAllSpellEvents() {
        for ()
    }
}
