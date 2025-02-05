package school.faang.sprint.first.catchevent.service;

import school.faang.sprint.first.catchevent.Model.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static int ID_COUNT = 0;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int spellEventId = getNextId();
        SpellEvent spellEventForAdd = new SpellEvent(spellEventId, eventType, actionDescription);

        spellById.put(spellEventId, spellEventForAdd);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEventForAdd);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent == null) {
            return;
        }

        spellsByType.get(spellEvent.getEventType())
                .removeIf(spell -> spell.getId() == id);

        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("Пока никто и ничего не кастовал, заходите позже");
            return;
        }

        spellById.values().forEach(System.out::println);
    }

    private int getNextId() {
        return ID_COUNT++;
    }
}
