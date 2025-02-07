package school.faang.BJS2_57203;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>(); //я сделал ее static final
    // чтобы метод print работал!
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String eventDescription) {
        if (eventType.isBlank()) {
            throw new IllegalArgumentException("Ошибка! Тип события не может быть пустым!");
        }
        if (eventDescription.isBlank()) {
            throw new IllegalArgumentException("Ошибка! Описание события не может быть пустым!");
        }

        SpellEvent spellEvent = new SpellEvent(eventType, eventDescription);
        SPELL_BY_ID.put(spellEvent.getId(), spellEvent);

        // я знаю про метод computeIfAbsent, но не смог его понять. Надеюсь когда начнем лямбды пойму!
        // (так что пока не обращяйте внимание на это)

        spellByType.putIfAbsent(spellEvent.getEventType(), new ArrayList<>());
        spellByType.get(spellEvent.getEventType()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!SPELL_BY_ID.containsKey(id)) {
            throw new IllegalArgumentException("Ошибка указан не сушествующий Id!!!");
        }
        return SPELL_BY_ID.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Ошибка указан неверный тип события!");
        }
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        String key = SPELL_BY_ID.get(id).getEventType();

        if (!SPELL_BY_ID.containsKey(id)) {
            throw new IllegalArgumentException("Ошибка! Вы вели не существующий ID!!!");
        } else {
            SPELL_BY_ID.remove(id);
        }

        List<SpellEvent> spellEvents = spellByType.get(key);
        if (spellEvents.isEmpty()) {
            spellByType.remove(key);
        } else {
            for (SpellEvent spellEvent : spellEvents) {
                if (spellEvent.getId() == id) {
                    spellEvents.remove(spellEvent);
                    break;
                }
            }
        }
    }

    public static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : SPELL_BY_ID.entrySet()) {
            System.out.println("ID события: " + entry.getKey() + ". Тип закленания: " +
                    entry.getValue().getEventType() + ". Описание события: " + entry.getValue().getAction());
        }
    }
}