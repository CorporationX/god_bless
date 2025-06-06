package school.faang.bjs2_79052;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static HashMap<Integer, SpellEvent> spellByld = new HashMap<>();
    private static HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellByld.put(SpellEvent.getId(), spellEvent);
        SpellEvent.setId(SpellEvent.getId() + 1);

        List<SpellEvent> spellList = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellList.add(spellEvent);
        spellsByType.put(eventType, spellList);
    }

    public static String getSpellEventByldId(int id) {
        return ((spellByld.get(id))).getEventType();
    }

    public static List<String> getSpellEventsByType(String eventType) {
        List<String> string = new ArrayList<>();
        for (SpellEvent event : spellsByType.get(eventType)) {
            string.add(event.getAction());
        }
        return string;
    }

    public static void deleteSpellEvent(int id) {
        if (!spellByld.containsKey(id)) {
            System.out.println("Такого номера нет");
            return;
        }

        SpellEvent value = spellByld.get(id);
        spellByld.remove(id);
        String evenType = value.getEventType();
        List<SpellEvent> spellList = spellsByType.get(evenType);

        if (spellList != null) {
            spellList.remove(value);

            if (spellList.isEmpty()) {
                spellsByType.remove(evenType);
            }
        }
    }

    public static void printAllSpellEvents() {
        System.out.println("Список: ");
        for (Map.Entry<Integer, SpellEvent> entry : spellByld.entrySet()) {
            System.out.println(entry.getKey() + " " + (entry.getValue()).getEventType() + " " +
                    (entry.getValue().getAction()));
        }
    }
}
