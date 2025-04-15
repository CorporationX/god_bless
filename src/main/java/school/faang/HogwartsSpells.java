package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    public HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    public HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        //int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
    }

    public SpellEvent getSpellEventById(int id) {
        for(SpellEvent value: spellById.values()){
            if(id == 0){

            }
        }
        return null;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return new ArrayList<>();
    }

    public void deleteSpellEvent(int id) {

    }

    public void printAllSpellEvents() {
        System.out.println();
    }
}
