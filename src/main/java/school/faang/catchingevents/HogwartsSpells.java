package school.faang.catchingevents;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class HogwartsSpells {
    private static final String EVENT_ID_FORMAT = "Id: %d, ";
    private static final String EVENT_TYPE_FORMAT = "spell type: %s, ";
    private static final String EVENT_ACTION_FORMAT = "action: %s\n";
    private static final String NEXT_LINE_FORMAT = ":\n";

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        if (spellsByType.containsKey(eventType)) {
            List<SpellEvent> events = spellsByType.get(eventType);
            events.add(spellEvent);
            spellsByType.put(eventType, events);
        } else {
            spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
        }
    }

    public void getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            System.out.print(id + NEXT_LINE_FORMAT);
            printSpellEvent(spellById.get(id));
            System.out.println();
        } else {
            System.out.println("No such spell event\n");
        }
    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            List<SpellEvent> events = spellsByType.get(eventType);
            System.out.print(eventType + NEXT_LINE_FORMAT);
            events.forEach(event ->
                    System.out.print("  " + event.getAction() + NEXT_LINE_FORMAT));
        }
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            List<SpellEvent> events = spellsByType.get(spellById.get(id).getEventType());
            events.remove(spellById.get(id));
            spellsByType.put(spellById.get(id).getEventType(), events);
            spellById.remove(id);
        } else {
            System.out.println("No such spell event\n");
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, event) -> {
            System.out.printf(EVENT_ID_FORMAT, event.getId());
            printSpellEvent(event);
        });
        System.out.println();
    }

    private void printSpellEvent(SpellEvent spellEvent) {
        System.out.printf(EVENT_TYPE_FORMAT, spellEvent.getEventType());
        System.out.printf(EVENT_ACTION_FORMAT, spellEvent.getAction());
    }
}
