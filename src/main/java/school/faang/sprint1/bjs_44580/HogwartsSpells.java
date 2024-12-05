package school.faang.sprint1.bjs_44580;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String , List<SpellEvent>> spellByType = new HashMap<>();

    public HogwartsSpells(HashMap<Integer, SpellEvent> spellById, HashMap<String, List<SpellEvent>> spellByType) {
        this.spellById = spellById;
        this.spellByType = spellByType;
    }

    HogwartsSpells() { }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        List<SpellEvent> spellEventList = getSpellEventByType(eventType);
        spellEventList.add(spellEvent);
        spellByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        if (!spellByType.containsKey(eventType)) {
            List<SpellEvent> result = new ArrayList<>();
            return result;
        }

        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent1 = spellById.remove(id);
        String spellEventType = spellEvent1.getEventType();
        List<SpellEvent> spellEventList = getSpellEventByType(spellEventType);
        spellEventList.remove(getSpellEventById(id));
        spellByType.put(spellEventType, spellEventList);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID события: " + entry.getValue().getId());
            System.out.println("Тип события: " + entry.getValue().getEventType());
            System.out.println("Действие события: " + entry.getValue().getAction() + "\n");
        }
        System.out.println("--------------");
    }
}
