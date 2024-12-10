package school.faang.tasks_44480;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellId = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(id, eventType, actionDescription);
        spellId.put(id, newEvent);
        spellType.computeIfAbsent(eventType, v -> new ArrayList<>()).add(newEvent);
    }

    public SpellEvent getSpellEventId(int id) {
        return Optional.ofNullable(spellId.get(id))
                .orElseThrow(() -> new NoSuchElementException("Заклинание с ID " + id + " не найдено."));
    }

    public List<SpellEvent> getSpellEventsType(String eventType) {
        return spellType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        Optional.ofNullable(spellId.remove(id)).ifPresent(event -> {
            spellType.computeIfPresent(event.getEventType(), (k, list) -> {
                list.remove(event);
                return list.isEmpty() ? null : list;
            });
        });
    }

    public void printAll() {
        spellId.values().stream()
                .sorted(Comparator.comparing(SpellEvent::getId))
                .forEach(System.out::println);
    }
}
