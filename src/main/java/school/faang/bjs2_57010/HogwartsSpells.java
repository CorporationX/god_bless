package school.faang.bjs2_57010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            return spellEvent;
        }
        throw new NoSuchElementException("No spell event with id " + id);
    }

    public List<SpellEvent> getSpellByType(String eventType) {
        return spellByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            System.out.println("Spell not found for ID: " + id);
            return;
        }

        // Получаю список по типу заклинаний
        List<SpellEvent> spells = spellByType.get(spellEvent.getEventType());

        // Проверяю, есть ли список по такому типу
        if (spells != null) {
            // Удаляю из списка все события, у которых getId() совпадает с id переданным в параметры
            spells.removeIf(spell -> spell.getId() == id);

            // Если после удаления spells пустой, то удаляю соответствующий
            // ключ из spellByType, так как в нем больше нет заклинаний для данного типа
            if (spells.isEmpty()) {
                spellByType.remove(spellEvent.getEventType());
            }

            // В итоге удаление происходит из обеих карт
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spell : spellById.values()) {
            System.out.printf("ID: %d, Event Type: %s, Action: %s%n",
                    spell.getId(), spell.getEventType(), spell.getAction());
        }
    }
}

