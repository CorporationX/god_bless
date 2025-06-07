package school.faang.bjs279721;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null && actionDescription == null) {
            if (eventType.isEmpty() && actionDescription.isEmpty()) {
                log.warn("Пустое значение");
                return;
            }
        }
        int idSpell = id++;
        SpellEvent spell = new SpellEvent(idSpell, eventType, actionDescription);

        spellById.put(id, spell);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spell);
        log.info("Заклинание добавлено под id {}", id);
    }

    public String getSpellEventById(int id) {
        if (id < 0) {
            log.warn("Отрицательное значение не проходит");
            return null;
        }

        if (spellById.containsKey(id)) {
            return spellById.get(id).getEventType();
        }

        log.info("Заклинание с таким id не найдено");
        return null;
    }

    public List<String> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isEmpty()) {
            return null;
        }
        if (spellsByType.containsKey(eventType)) {
            List<SpellEvent> list = spellsByType.get(eventType);
            List<String> result = new ArrayList<>();
            for (SpellEvent spellEvent : list) {
                result.add(spellEvent.getAction());
            }
            return result;
        }

        log.info("Такой тип заклинаний еще не придуман.");
        return null;
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            log.warn("Отрицательного id не существует");
            return;
        }
        if (spellById.containsKey(id)) {
            spellsByType.remove(spellById.get(id).getEventType());
            spellById.remove(id);
            log.info("Заклинание удалено с базы даных");
            return;
        }
        log.info("Заклинания под таки Id не найдено");
    }

    public void printAllSpellEvents() {
        if (!spellById.isEmpty()) {
            for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
                int id = entry.getKey();
                String type = entry.getValue().getEventType();
                String action = entry.getValue().getAction();
                System.out.printf("Id = %s. Тип: %s. Что делает: %s.%n", id, type, action);
            }
            return;
        }
        log.info("База данных заклинаний пока пуска.");
    }
}
