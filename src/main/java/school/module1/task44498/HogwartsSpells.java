package school.module1.task44498;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById;
    Map<String, List<SpellEvent>>spellsByType;

    public void addSpellEvent(int id, String eventType, String actionDescription){
        SpellEvent spellEvent = new SpellEvent(id,eventType, actionDescription );
        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id){
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType){
       return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id){
        spellById.remove(id);
        spellsByType.remove(spellsByType.get);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
