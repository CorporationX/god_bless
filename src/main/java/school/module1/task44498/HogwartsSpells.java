package school.module1.task44498;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ToString
public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        //Этот кусочек не знаю и пока не понял, взял напрямую с курса. Буду изучать
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        System.out.println("Добавлен спелл: " + spellById);
        System.out.println("Добавлен спелл: " + spellsByType);
    }

    public SpellEvent getSpellEventById(int id) {
        System.out.println("Нужный спелл: " + spellById.get(id));
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        System.out.println("Нужные спеллы по типу " + eventType + " " + spellsByType.get(eventType));
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        System.out.println("Удален спелл " + spellById.get(id) + " из spellById");
        spellById.remove(id);

        SpellEvent spell = spellById.remove(id);
        if (Objects.nonNull(spell)) {
            spellsByType.get(spell.getEventType()).remove(spell);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
