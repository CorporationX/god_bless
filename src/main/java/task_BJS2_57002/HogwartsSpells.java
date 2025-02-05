package task_BJS2_57002;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    public static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    public static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int id = 0;

    public static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spellEventList = new ArrayList<>();
        spellEventList.add(spellEvent);



        for (SpellEvent event : spellEventList) {
            if (!spellsByType.containsKey(eventType)) {
                spellsByType.put(eventType, new ArrayList<>());
            }
            spellsByType.get(eventType).add(event);

        }


        id++;
    }

}
