package school.faang.bjs2_57324;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellBuild = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не должен быть пустым " +
                    "или содержать одни пробелы. Вы указали: " + eventType);
        }
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Описание действия не должно быть пустым " +
                    "или содержать одни пробелы. Вы указали: " + actionDescription);
        }
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        int id = SpellEvent.getId();
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        spellBuild.put(id, spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не должен быть меньше 0");
        }
        return spellBuild.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не должен быть пустым " +
                    "или содержать одни пробелы. Вы указали: " + eventType);
        }
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не должен быть меньше 0");
        }
        SpellEvent spellEvent = spellBuild.get(id);
        spellBuild.remove(id);
        spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellBuild.entrySet()) {
            int key = entry.getKey();
            SpellEvent value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

}
