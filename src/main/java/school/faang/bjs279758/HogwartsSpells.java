package school.faang.bjs279758;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById;
    private HashMap<String, List<SpellEvent>> spellsByType;
    private int spellId;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
        spellId = 1;
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = spellId++;
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
        System.out.println("Spell event added: " + event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> list = spellsByType.get(event.getEventType());
            if (list != null) {
                list.removeIf(spell -> spell.getId() == id);
                if (list.isEmpty()) {
                    spellsByType.remove(event.getEventType());
                }
            }
            System.out.println("Spell event with id deleted: " + id);
            System.out.println("Deleted spell: " + event);
        } else {
            System.out.println("Spell event not found: " + id);
        }
    }

    public void printAllSpellEvent() {
        if (spellById.isEmpty()) {
            System.out.println("No spell event found");
            return;
        }
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
