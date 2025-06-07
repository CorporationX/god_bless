package school.faang.catch_event;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import school.faang.util.ParameterUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.util.ParameterUtil.checkStringArg;

@Getter
@Setter
public class HogwartsSpells {
    @Setter(AccessLevel.PRIVATE)
    private static int idCounter;

    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        checkStringArg(eventType, "eventType");
        checkStringArg(actionDescription, "actionDescription");

        SpellEvent spellEvent = new SpellEvent(++idCounter, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
        return spellEvent;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        checkStringArg(eventType, "eventType");
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        return spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            return null;
        }

        spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        return spellEvent;
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("there's not a single spell at Hogwarts.");
            return;
        }

        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }
}
