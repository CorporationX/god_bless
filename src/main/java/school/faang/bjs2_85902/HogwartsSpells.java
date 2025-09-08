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
        System.out.println(spellById.get(id).getDescription());
    }

    protected void getSpellEventByType(String evenType) {
        if (evenType == null || evenType.isEmpty()) {
            throw new IllegalArgumentException("Тип события не может быть пустым");
        }
        System.out.println(spellByType.get(evenType));
    }

    protected void deleteSpellEvent(int id) {
        validationId(id);
        spellByType.remove(spellById.get(id).getDescription());
        spellById.remove(id);
    }

    protected void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("%d Id Зелья, %s  - Эффект зелья\n",
                    entry.getKey(), entry.getValue().getDescription());
        }
    }

    private void validationSpells(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип события не может быть пустым");
        }
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Описание действия не может быть пустым");
        }
        if (spellById.containsValue(eventType)) {
            throw new IllegalArgumentException("Данное зелье уже присутствует");
        }
    }

    private void validationId(int ids) {
        if (ids > id) {
            throw new IllegalArgumentException("Этого Id не найдено ");
        }
    }

}
