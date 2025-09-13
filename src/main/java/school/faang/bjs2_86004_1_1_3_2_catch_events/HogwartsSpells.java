package school.faang.bjs2_86004_1_1_3_2_catch_events;

import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<Integer, List<SpellEvent>> spellsByType;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(SpellEvent.ids, eventType, actionDescription);
        SpellEvent.ids++;
        spellById.put(spellEvent.getId(), spellEvent);
    }

    public SpellEvent getSpellById(Integer id) {
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(Integer id) {
        return this.spellsByType.get(id);
    }

    public void deleteSpellEvent(Integer id) {
        this.spellById.remove(id);
        this.spellsByType.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : this.spellById.entrySet()) {
            System.out.println(entry.getValue().getId());
            System.out.println(entry.getValue().getEventType());
            System.out.println(entry.getValue().getAction());
        }
    }

}
