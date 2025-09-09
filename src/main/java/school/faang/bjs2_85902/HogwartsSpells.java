package school.faang.bjs2_85902;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    protected void addSpellEvent(String eventType, String actionDescription) {
        validateSpells(eventType, actionDescription);
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    protected void getSpellEventById(int id) {
        validateId(id);
        if (spellById.containsKey(id)) {
            System.out.printf("%nВаше заклинание по Id- %d%n%s -Способность%n%s - Эффект способности%n",
                    spellById.get(id).getId(), spellById.get(id).getEventType(), spellById.get(id).getAction());
        }
    }

    protected List<SpellEvent> getSpellEventByType(String evenType) {
        if (evenType == null || evenType.isBlank()) {
            throw new IllegalArgumentException("Тип события не может быть пустым");
        }
        List<SpellEvent> result = new ArrayList();
        if (spellByType.containsKey(evenType)) {
            result.addAll(spellByType.get(evenType));
            return result;
        }
        return result;
    }

    protected void deleteSpellEvent(int id) {
        validateId(id);
        SpellEvent spell = spellById.remove(id);
        if (spell != null) {
            List<SpellEvent> eventList = spellByType.get(spell.getEventType());
            spellByType.remove(spell.getAction());
            if (eventList != null) {
                spellByType.remove(spell.getEventType());
            }
        }
    }

    protected void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("%n%d Id Способности, %s  - Способность%n%s - Эффект способности%n",
                    entry.getValue().getId(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }

    private void validateSpells(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип события не может быть пустым");
        }
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Описание действия не может быть пустым");
        }

    }

    private void validateId(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Этого Id не найдено ");
        }
    }

}
