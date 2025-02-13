package school.faang.task57212.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int uniqueId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || actionDescription == null) {
            System.out.println("Входные параметры должны быть заполнены");
            return;
        }
        uniqueId += 1;
        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);
        spellById.put(uniqueId, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        if (spellById.get(id) == null) {
            System.out.println("Нет SpellEvent для печати с id " + id);
        } else {
            System.out.println("Печать SpellEvent с id " + ": " + spellById.get(id));
        }
    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.get(eventType) == null) {
            System.out.println("Нет SpellEvent для печати с типом " + eventType);
        } else {
            System.out.println("Печать SpellEvents с типом " + eventType + ": " + spellsByType.get(eventType));
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent targetSpell = spellById.get(id);
        if (targetSpell != null) {
            List<SpellEvent> targetList = spellsByType.get(targetSpell.getEventType());
            if (targetList != null && !targetList.isEmpty()) {
                targetList.remove(targetSpell);
                spellById.remove(id);
            }
        }
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("Печать всех SpellEvents невозможна, список пуст");
        } else {
            System.out.println("Печать всех SpellEvents:");
            for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
                System.out.println(spell.getValue());
            }
        }
    }
}
