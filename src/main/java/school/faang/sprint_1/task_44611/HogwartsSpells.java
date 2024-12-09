package school.faang.sprint_1.task_44611;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();;
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public SpellEvent addSpellEvent(int id, String eventType, String actionDescription) {
        // создаём новое заклинание
        var spellEvent = new SpellEvent(id, eventType, actionDescription);

        // добавляем заклинание в spellById
        spellById.put(id, spellEvent);

        // добавляем заклинание в spellsByType
        spellsByType.putIfAbsent(eventType, new ArrayList<SpellEvent>());
        var list = spellsByType.get(eventType);
        list.add(spellEvent);

        // возвращаем новое заклинание
        return spellEvent;
    }

    @Nullable
    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    @Nullable
    public List<SpellEvent> getSpellEventsByType(String evenType) {
        return spellsByType.get(evenType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        var spellEvent = spellById.remove(id); // удаляем заклинание из spellById

        if (spellEvent != null) {
            var eventType = spellEvent.eventType(); // получаем тип заклинания

            var list = spellsByType.get(eventType); // получаем список по этому типу

            if (list != null) {
                list.remove(spellEvent); // удаляем заклинание из списка

                if (list.isEmpty()) {
                    spellsByType.remove(eventType); // если список пуст, удаляем его из мапы
                }
            }
        }

        return spellEvent; // возвращаем заклинание, которое удалили
    }

    public void printAllSpellEvents() {
        System.out.println("Заклинания:");
        spellById.forEach((key, value) -> {
            System.out.println(value);
        });
        System.out.println();
    }
}
