package school.faang.catching_events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(newSpellEvent.getId(), newSpellEvent);
        spellsByType
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(newSpellEvent);
    }

    static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    static List<SpellEvent> getSpellEventsByType(String eventType) {
        return new ArrayList<>(spellsByType.getOrDefault(eventType, Collections.emptyList()));
    }

    static void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new IllegalArgumentException("Spell with ID " + id + " not found");
        }
        spellById.remove(id);
        List<SpellEvent> events = spellsByType.get(event.getEventType());
        if (events != null) {
            events.remove(event);
            if (events.isEmpty()) {
                spellsByType.remove(event.getEventType());
            }
        }
    }

    static void printAllEvents() {
        spellById.forEach((id, spell) ->
                System.out.println("ID: " + id + ";  "
                        + "ТИП: " + spell.getEventType() + ";  "
                        + "ОПИСАНИЕ: " + spell.getAction())
        );
    }

    public static void main(String[] args) {
        System.out.println();

        addSpellEvent("Чар", "Подчиняет волю противника");
        addSpellEvent("Трансфигурация", "Преобразует предмет в другой объект");
        addSpellEvent("Чар", "Восстанавливает здоровье цели");
        addSpellEvent("Трансфигурация", "Создает обманчивые образы");
        addSpellEvent("Чар", "Призывает магических существ");
        addSpellEvent("Зачарование", "Наделяет объект магическими свойствами");
        addSpellEvent("Зачарование", "Накладывает негативный эффект");
        addSpellEvent("Чар", "Мгновенно перемещает объект");
        addSpellEvent("Чар", "Управляет природными элементами");
        addSpellEvent("Трансфигурация", "Раскрывает скрытую информацию");

        System.out.println("=== ДОБАВЛЕННЫЕ ЗАКЛИНАНИЯ ===");
        printAllEvents();

        System.out.println("\n=== СТАТИСТИКА ===");
        System.out.println("Всего заклинаний: " + spellById.size());
        System.out.println("Заклинаний по типам:");
        spellsByType.forEach((type, spells) ->
                System.out.println("  " + type + ": " + spells.size() + " заклинаний")
        );

        System.out.println("\n=== ТЕСТ: ВЫВОД ПО ТИПАМ ===");
        System.out.print("\n\tТип: Чары");
        List<SpellEvent> listOfChar = getSpellEventsByType("Чар");
        System.out.println("\nВсего заклинаний: " + listOfChar.size());
        listOfChar.forEach(System.out::println);

        System.out.print("\n\tТип: Зачарование");
        List<SpellEvent> listOfEnchant = getSpellEventsByType("Зачарование");
        System.out.println("\nВсего заклинаний: " + listOfEnchant.size());
        listOfEnchant.forEach(System.out::println);

        System.out.println("\n=== ТЕСТ: ВЫВОД ПО ID ===");
        System.out.println("ID: 1 - " + getSpellEventById(1));
        System.out.println("ID: 4 - " + getSpellEventById(4));
        System.out.println("ID: 5 - " + getSpellEventById(5));

        deleteSpellEvent(1);
        deleteSpellEvent(4);
        deleteSpellEvent(5);
        deleteSpellEvent(7);
        deleteSpellEvent(8);
        deleteSpellEvent(10);

        System.out.println("\n\tВывод всех заклинаний:");
        printAllEvents();
    }
}
