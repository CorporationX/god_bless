package school.faang.sprint_1.task_44611;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
    }

    public SpellEvent addSpellEvent(int id, String eventType, String actionDescription) {
        // создаём новое заклинание
        var spellEvent = new SpellEvent(id, eventType, actionDescription);

        // добавляем заклинание в spellById
        spellById.put(id, spellEvent);

        // добавляем заклинание в spellsByType
        if (!spellsByType.containsKey(eventType)) {
            var newList = new ArrayList<SpellEvent>();
            spellsByType.put(eventType, newList);
        }
        var list = spellsByType.get(eventType);
        list.add(spellEvent);

        // возвращаем новое заклинание
        return spellEvent;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String evenType) {
        return spellsByType.get(evenType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        var spellEvent = spellById.remove(id); // удаляем заклинание из spellById

        if (spellEvent != null) {
            var eventType = spellEvent.getEventType(); // получаем тип заклинания

            var list = spellsByType.get(eventType); // получаем список по этому типу

            list.remove(spellEvent); // удаляем заклинание из списка

            if (list.isEmpty()) {
                spellsByType.remove(eventType); // если список пуст, удаляем его из мапы
            }
        }

        return spellEvent; // возвращаем заклинание, которое удалили
    }

    public void printAllSpellEvents() {
        System.out.println("Заклинания:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }
}
