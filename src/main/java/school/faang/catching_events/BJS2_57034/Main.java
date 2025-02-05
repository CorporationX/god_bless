package school.faang.catching_events.BJS2_57034;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();

        hogwarts.addSpellEvent("Чар", "Превращает предмет в золото");
        hogwarts.addSpellEvent("Защита", "Защищает от атак");
        hogwarts.addSpellEvent("Трансфигурация", "Преобразует человека в животное");
        hogwarts.addSpellEvent("Чар", "Создает иллюзию");

        SpellEvent eventById = hogwarts.getSpellEventById(1);

        List<SpellEvent> eventsByType = hogwarts.getSpellEventsByType("Чар"); // Ожидается 2 события

        hogwarts.deleteSpellEvent(1);

        try {
            hogwarts.getSpellEventById(1);
        } catch (NoSuchElementException ignored) {
        }

        hogwarts.printAllSpellEvents();
    }
}
