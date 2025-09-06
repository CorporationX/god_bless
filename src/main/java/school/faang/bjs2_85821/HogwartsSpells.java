package school.faang.bjs2_85821;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int nextId = 1;

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || actionDescription == null) {
            throw new IllegalArgumentException("Поля не могут быть null");
        }

        int uniqueId = nextId++;

        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);

        spellById.put(uniqueId, spellEvent);

        // add возвращет boolean, поэтому в одну строку не получается
        List<SpellEvent> spellsList = spellByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spellsList.add(spellEvent);

        return spellEvent;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.getOrDefault(eventType, new ArrayList<>());
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent == null) {
            return false;
        }

        spellById.remove(id);

        String eventType = spellEvent.getEventType();
        List<SpellEvent> spellsOfType = spellByType.get(eventType);

        if (spellsOfType != null) {
            spellsOfType.remove(spellEvent);

            if (spellsOfType.isEmpty()) {
                spellByType.remove(eventType);
            }
        }

        return true;
    }

    public void printAllSpellEvents() {
        System.out.println("ВСЕ СОБЫТИЯ ЗАКЛИНАНИЙ");

        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            int id = entry.getKey();
            SpellEvent spellEvent = entry.getValue();

            System.out.println("ID: " + id +
                    ", Тип: '" + spellEvent.getEventType() +
                    "', Действие: '" + spellEvent.getAction() + "'");
        }

        if (spellById.isEmpty()) {
            System.out.println("Событий заклинаний не найдено.");
        }
    }
}
