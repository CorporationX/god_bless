package CatchingEvents;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @EqualsAndHashCode
    public static class HogwartsSpells {
        private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
        private final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
        private int id = 1;


        public void addSpellEvent(String eventType, String actionDescription) {
            SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
            int currentId = id++;
            spellById.put(id, spellEvent);

            spellById.put(currentId, spellEvent);
            spellsByType.putIfAbsent(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
        }

        public SpellEvent getSpellEventById(int id) {
            return spellById.get(id);
        }

        public List<SpellEvent> getSpellEventsByType(String eventType) {
            return spellsByType.getOrDefault(eventType, new ArrayList<>());
        }

        public void deleteSpellEvent(int id) {
            SpellEvent spellEvent = spellById.remove(id);
            if (spellEvent != null) {
                List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
                if (events != null) {
                    events.remove(spellEvent);
                }
            }
        }

        public void printAllSpellEvents() {
            for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Защита от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Создает защитное поле");

        hogwartsSpells.printAllSpellEvents();

        System.out.println("Получение заклинания по ID 1: " + hogwartsSpells.getSpellEventById(1));

        hogwartsSpells.deleteSpellEvent(1);
        System.out.println("После удаления заклинания с ID 1:");
        hogwartsSpells.printAllSpellEvents();
    }

}
