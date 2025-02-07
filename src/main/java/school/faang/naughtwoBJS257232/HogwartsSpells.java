package school.faang.naughtwoBJS257232;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final LinkedList<Integer> idList = new LinkedList<>();

    private void setIdList(LinkedList<Integer> idList) {
        if (idList.isEmpty()) {
            idList.add(1);
        } else {
            idList.add(idList.getLast() + 1);
        }
    }

    public void addSpellEvent(String eventType, String action) {
        setIdList(this.idList);
        int key = this.idList.getLast();
        SpellEvent spellEvent = new SpellEvent(key, eventType, action);

        this.spellById.put(key, spellEvent);

        if (!this.spellsByType.containsKey(eventType)) {
            this.spellsByType.put(eventType, new ArrayList<>());
            this.spellsByType.get(eventType).add(spellEvent);
        } else {
            this.spellsByType.get(eventType).add(spellEvent);
        }
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        if (!this.spellById.containsKey(id)) {
            System.out.println("Event not found for this ID");
            return Optional.empty();
        } else {
            System.out.println("Event found for this ID");
            return Optional.ofNullable(this.spellById.get(id));
        }
    }

    public Optional<List<SpellEvent>> getSpellEventsByType(String eventType) {
        if (!this.spellsByType.containsKey(eventType)) {
            System.out.println("List of events not found for this type");
            return Optional.empty();
        } else {
            System.out.println("List of events found for this type");

            return Optional.ofNullable(this.spellsByType.get(eventType));
        }
    }

    public void deleteSpellEvent(int id) {
        if (!this.idList.contains(id)) {
            System.out.println("Event not found for this ID");
        } else {
            String eventType = this.spellById.get(id).getEventType();
            this.spellById.remove(id);
            this.spellsByType.remove(eventType);
            System.out.println("Event for this ID found and remove");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : this.spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
