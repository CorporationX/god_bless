package school.faang.bjs244404.repository;

import lombok.NoArgsConstructor;
import school.faang.bjs244404.model.EventType;
import school.faang.bjs244404.model.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class SpellEventRepository {

    private final Map<Integer, SpellEvent> spellToId = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsToType = new HashMap<>();

    public void add(SpellEvent spellEvent) {
        spellToId.put(spellEvent.id(), spellEvent);
        List<SpellEvent> spellEventList = spellsToType.computeIfAbsent(spellEvent.eventType(), list -> new ArrayList<>());
        spellEventList.add(spellEvent);
    }

    public SpellEvent get(int id) {
        return this.spellToId.get(id);
    }

    public List<SpellEvent> get(EventType eventType) {
        return spellsToType.get(eventType);
    }

    public SpellEvent remove(int id) {
        SpellEvent removedItem = spellToId.remove(id);
        List<SpellEvent> spellEventList = spellsToType.get(removedItem.eventType());
        spellEventList.remove(removedItem);
        return removedItem;
    }

    public void printAllSpellEvents() {
        spellToId.entrySet().forEach(System.out::println);
    }
}
