package school.faang.hogwarts.spell.management;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);

        log.info("Добавлено новое заклинание: {}", spellEvent);
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        return Optional.ofNullable(spellById.get(id));
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellsOfType = spellsByType.get(spellEvent.getEventType());
            if (spellsOfType != null) {
                spellsOfType.removeIf(spell -> spell.getId() == id);
                if (spellsOfType.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
            log.info("Заклинание с ID {} удалено.", id);
        }
        log.info("Заклинание с ID {} не найдено.", id);
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("В системе нет заклинаний.\n");
            return;
        }

        System.out.println("\nВсе заклинания:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
