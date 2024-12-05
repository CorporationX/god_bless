package school.faang.task_44492;


import java.util.*;

public class HogwartsSpells {

    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        spellById.put(id, new SpellEvent(id, eventType, actionDescription));

        boolean exists = spellsByType.entrySet().stream()
                .anyMatch(key -> key.getKey().equals(eventType));

        if (exists) {
            spellsByType.entrySet().stream()
                    .filter(key -> key.getKey().equals(eventType))
                    .forEach(value -> value.getValue()
                            .add(new SpellEvent(id, eventType, actionDescription)));
        } else {
            spellsByType.put(eventType, new ArrayList<>(List.of(new SpellEvent(id, eventType, actionDescription))));
        }

    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.entrySet().stream()
                .filter(key -> key.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("По данному id: " + id + " ничего не найдено"));
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {


        return spellsByType.entrySet().stream()
                .filter(key -> key.getKey().equals(eventType))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("По данному типу: " + eventType + " ничего не найдено"));

    }

    public static void deleteSpellEvent(int id) {
        SpellEvent value = spellById.entrySet().stream()
                .filter(key -> key.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("По данному id: " + id + " ничего не найдено"));

        spellById.remove(id);

        spellsByType.remove(value.getEventType());

        System.out.println("Удаление выполнено");

    }

    public static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("id: %d | eventType: %s | action: %s%n",
                    entry.getValue().getId(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }

}
