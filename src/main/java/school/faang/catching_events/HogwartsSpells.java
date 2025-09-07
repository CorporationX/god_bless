package school.faang.catching_events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private int nextId = 1;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    void addSpellEvent(String eventType, String actionDescription) {
        int id = nextId++;
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, newSpellEvent);
        spellsByType
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(newSpellEvent);
    }

    SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("Spell with ID " + id + " not found");
        }
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events != null) {
            events.remove(spellEvent);
            if (events.isEmpty()) {
                spellsByType.remove(spellEvent.getEventType());
            }
        }
    }

    void printAllEvents() {
        spellById.forEach((id, spell) ->
                System.out.println("ID: " + id + ";  "
                        + "ТИП: " + spell.getEventType() + ";  "
                        + "ОПИСАНИЕ: " + spell.getAction())
        );
    }

    public static void main(String[] args) {
        HogwartsSpells app = new HogwartsSpells();
        System.out.println();

        app.addSpellEvent("Чар", "Подчиняет волю противника");
        app.addSpellEvent("Трансфигурация", "Преобразует предмет в другой объект");
        app.addSpellEvent("Чар", "Восстанавливает здоровье цели");
        app.addSpellEvent("Трансфигурация", "Создает обманчивые образы");
        app.addSpellEvent("Чар", "Призывает магических существ");
        app.addSpellEvent("Зачарование", "Наделяет объект магическими свойствами");
        app.addSpellEvent("Зачарование", "Накладывает негативный эффект");
        app.addSpellEvent("Чар", "Мгновенно перемещает объект");
        app.addSpellEvent("Чар", "Управляет природными элементами");
        app.addSpellEvent("Трансфигурация", "Раскрывает скрытую информацию");

        System.out.println("=== ДОБАВЛЕННЫЕ ЗАКЛИНАНИЯ ===");
        app.printAllEvents();

        System.out.println("\n=== СТАТИСТИКА ===");
        System.out.println("Всего заклинаний: " + app.spellById.size());
        System.out.println("Заклинаний по типам:");
        app.spellsByType.forEach((type, spells) ->
                System.out.println("  " + type + ": " + spells.size() + " заклинаний")
        );

        System.out.println("\n=== ТЕСТ: ВЫВОД ПО ТИПАМ ===");
        System.out.print("\n\tТип: Чары");
        List<SpellEvent> listOfChar = app.getSpellEventsByType("Чар");
        System.out.println("\nВсего заклинаний: " + listOfChar.size());
        listOfChar.forEach(System.out::println);

        System.out.print("\n\tТип: Зачарование");
        List<SpellEvent> listOfEnchant = app.getSpellEventsByType("Зачарование");
        System.out.println("\nВсего заклинаний: " + listOfEnchant.size());
        listOfEnchant.forEach(System.out::println);

        System.out.println("\n=== ТЕСТ: ВЫВОД ПО ID ===");
        System.out.println("ID: 1 - " + app.getSpellEventById(1));
        System.out.println("ID: 4 - " + app.getSpellEventById(4));
        System.out.println("ID: 5 - " + app.getSpellEventById(5));

        app.deleteSpellEvent(1);
        app.deleteSpellEvent(4);
        app.deleteSpellEvent(5);
        app.deleteSpellEvent(7);
        app.deleteSpellEvent(8);
        app.deleteSpellEvent(10);

        System.out.println("\n\tВывод всех заклинаний:");
        app.printAllEvents();
    }
}