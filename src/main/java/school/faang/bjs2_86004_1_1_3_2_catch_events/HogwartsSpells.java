package school.faang.bjs2_86004_1_1_3_2_catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellById = new HashMap<Integer, SpellEvent>();
        this.spellsByType = new HashMap<String, List<SpellEvent>>();
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(SpellEvent.ids, eventType, actionDescription);
        SpellEvent.ids++;

        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<SpellEvent>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(Integer id) {
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        return this.spellsByType.get(eventType);
    }

    public void deleteSpellEvent(Integer id) {
        SpellEvent deletingEvent = this.spellById.remove(id);

        if (deletingEvent != null) {
            List<SpellEvent> listForDeleting = this.spellsByType.get(deletingEvent.getEventType());
            if (listForDeleting != null) {
                listForDeleting.remove(deletingEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : this.spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
