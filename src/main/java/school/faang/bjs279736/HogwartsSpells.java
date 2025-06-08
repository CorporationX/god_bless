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

    public void getSpellEventById(int id) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getKey() == id) {
                log.info("Нашли заклинание по id");
                System.out.println(entry.getValue().getAction());
            }
        }
    }

    public void getSpellEventsByType(String eventType) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            if (entry.getKey().equals(eventType)) {
                for (SpellEvent list : entry.getValue()) {
                    result.add(list.getAction());
                }
                log.info("Нашли заклинане");
                System.out.println(result);
            }
        }
        if (result.size() == 0) {
            log.error("Заклинание не найдено");
        }
    }

    public void deleteSpellEvent(int id) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getKey() == id) {
                spellById.remove(entry.getKey());
            }// Исправить!!!!!
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("id: " + entry.getKey() + ". Заклинание: " + entry.getValue().toString());
        }
        System.out.println("\n");
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            System.out.println("Событие заклинание: " + entry.getKey() + ". Заклинание: " + entry.getValue().toString());
        }
    }
}
