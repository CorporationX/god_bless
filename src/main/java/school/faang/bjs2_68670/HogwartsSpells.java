package school.faang.bjs2_68670;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellsByType;

    private Integer lastId = 0;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(getNextId(), eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(), spellEventType -> new ArrayList<>()).add(spellEvent);
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        return Optional.ofNullable(spellById.get(id));
    }

    public Optional<List<SpellEvent>> getSpellEventsByType(String eventType) {
        return Optional.ofNullable(spellsByType.get(eventType));
    }

    public Optional<SpellEvent> deleteSpellEvent(int id) {
        Optional<SpellEvent> optionalEvent = getSpellEventById(id);
        if (optionalEvent.isEmpty()) {
            return Optional.empty();
        }
        String eventType = optionalEvent.get().getEventType();
        Optional<List<SpellEvent>> optionalEventList = getSpellEventsByType(eventType);
        if (optionalEventList.isPresent()) {
            List<SpellEvent> eventList = optionalEventList.get();
            eventList.removeIf(spellEvent -> spellEvent.getId() == id);
        }
        return Optional.of(spellById.remove(id));
    }

    public void printAllSpellEvents() {
        for (var spellEntry : spellById.entrySet()) {
            System.out.printf("Spell: %s\n".formatted(spellEntry.getValue()));
        }
    }

    private Integer getNextId() {
        return ++lastId;
    }

}
