package school.faang.bjs2_85902;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int id = 1;

    protected void addSpellEvent(String eventType, String actionDescription) {
        validationSpells(eventType, actionDescription);
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription, id);
        spellById.put(id, spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
        id++;
    }

    protected void getSpellEventById(int id) {
        validationId(id);
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getValue().getId() == id) {
                System.out.printf("%nВаше заклинание по Id- %d%n%s -Зелье%n%s - Эффект зелья%n",
                        entry.getValue().getId(),  entry.getValue().getEventType(), entry.getValue().getAction());
            }
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
        validationId(id);
        SpellEvent spell = spellById.remove(id);
        if (spell != null) {
            List<SpellEvent> eventList = spellByType.get(spell);
            spellByType.remove(spell.getAction());
            if (eventList != null) {
                spellByType.remove(eventList);
            }
        }
    }

    protected void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("%n%d Id Зелья, %s  - Зелье%n%s - Эффект зелья%n",
                    entry.getKey(),  entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }

    private void validationSpells(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип события не может быть пустым");
        }
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Описание действия не может быть пустым");
        }

    }

    private void validationId(int id) {
        if (id > this.id) {
            throw new IllegalArgumentException("Этого Id не найдено ");
        }
    }

}
