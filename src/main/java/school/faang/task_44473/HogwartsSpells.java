package school.faang.task_44473;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent request = new SpellEvent(id, EventType.valueOf(eventType), actionDescription);
        if(spellById.containsKey(id)){
            return;
        }
        spellById.put(id, request);
        /*
            параметр p передавать обязательно! Без него лямбда-функция не работает!
            https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html
            computeIfAbsent(key, k -> new Value(f(k)));
         */
        spellsByType.computeIfAbsent(eventType, (p) -> new ArrayList<>()).add(request);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0 || !spellById.containsKey(id)){
            throw new IllegalArgumentException("The id is incorrect!");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if(eventType.isBlank()){
            throw new IllegalArgumentException("Event type is incorrect!");
        } else if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Event was not founded!");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent request = getSpellEventById(id);
        spellById.remove(request.getId());
        spellsByType.remove(request.getEventType().toString());
    }

    public void printAllSpellEvents() {
        spellById.forEach(
                (k,v) -> System.out.println(k + " -> " + v)
        );
    }
}
