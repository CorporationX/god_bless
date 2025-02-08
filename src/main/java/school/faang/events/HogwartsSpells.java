package school.faang.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HogwartsSpells {
    private static final Set<String> VALID_EVENT_TYPE =
            new HashSet<>(List.of("Чары", "Стихия", "Защита", "Трансфигурация"));

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int count = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        checkEventSpell(eventType);
        checkAction(actionDescription);

        count++;
        spellsByType.computeIfAbsent(eventType, newEvent -> new ArrayList<>())
                .add(new SpellEvent(count, eventType, actionDescription));
        spellById.put(count, new SpellEvent(count, eventType, actionDescription));
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get((eventType));
    }

    public boolean deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            String eventType = spellById.get(id).getEventType();
            String action = spellById.get(id).getAction();
            spellsByType.get(eventType).remove(new SpellEvent(id, eventType, action));
            if (spellsByType.get(eventType).isEmpty()) {
                spellsByType.remove(eventType);
            }
            spellById.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public String printAllSpellEvents() {
        StringBuilder allSpellEvents = new StringBuilder();
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            allSpellEvents.append(String.format("%d: тип события %s, действие %s \n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction()));

        }
        return allSpellEvents.toString();
    }

    private void checkEventSpell(String eventType) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым");
        }

        if (!VALID_EVENT_TYPE.contains(eventType)) {
            throw new IllegalArgumentException("Тип заклинания должен соответствовать списку: " + VALID_EVENT_TYPE);
        }
    }

    private void checkAction(String actionDescription) {
        if (actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("Действие не может быть пустым");
        }
    }
}