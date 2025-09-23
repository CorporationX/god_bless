package school.faang.sprint1.catchevent;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class HogwartsSpellsImpl implements HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 1;

    @Override
    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        validateSpellEventData(eventType, actionDescription);

        SpellEvent event = new SpellEvent(generateId(), eventType, actionDescription);

        spellById.put(event.getId(), event);
        spellsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);

        return event;
    }

    @Override
    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new NoSuchElementException("WARN: No spell event with ID " + id + " found");
        }
        return event;
    }

    @Override
    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, List.of());
    }

    @Override
    public boolean deleteSpellEvent(int id) {
        SpellEvent eventDeleted = spellById.remove(id);
        if (eventDeleted == null) {
            return false;
        }
        spellsByType.getOrDefault(eventDeleted.getEventType(), List.of()).remove(eventDeleted);
        return true;
    }

    @Override
    public void printAllSpellEvents() {

        StringBuilder sb = new StringBuilder("All current stored spell events:\n");

        spellById.forEach((id, spell) ->
            sb.append(String.format("ID: %d, Type: %s, Action: %s%n",
                id, spell.getEventType(), spell.getAction())));

        String spellData = sb.toString();
        System.out.println(spellData);
    }

    private int generateId() {
        return nextId++;
    }

    private void validateSpellEventData(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("WARN: Event type cannot be blank.");
        }
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("WARN: Action description cannot be blank.");
        }
    }
}
