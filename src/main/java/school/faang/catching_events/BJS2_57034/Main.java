package school.faang.catching_events.BJS2_57034;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();
        LOGGER.info("Creating {}", hogwarts);

        hogwarts.addSpellEvent("Чар", "Превращает предмет в золото");
        hogwarts.addSpellEvent("Защита", "Защищает от атак");
        hogwarts.addSpellEvent("Трансфигурация", "Преобразует человека в животное");
        hogwarts.addSpellEvent("Чар", "Создает иллюзию");
        hogwarts.addSpellEvent("Защита", "Создаёт барьер");
        LOGGER.info("Adding spellEvent");

        SpellEvent eventById = hogwarts.getSpellEventById(1);
        System.out.println(eventById);
        LOGGER.info("Getting spellEvent");

        List<SpellEvent> eventsByType = hogwarts.getSpellEventsByType("Чар");
        System.out.println(eventsByType);
        LOGGER.info("Getting spellEvent");

        System.out.println("Added " + hogwarts.getSpellEventsByType("Чар")
                .size() + " spell events with type 'Чар'");

        hogwarts.deleteSpellEvent(1);
        LOGGER.info("deleting spellEvent");

        try {
            hogwarts.getSpellEventById(1);
        } catch (NoSuchElementException e) {
            LOGGER.error("getSpellEventById: ", e);
        }

        hogwarts.printAllSpellEvents();
        LOGGER.info("Printing all spellEvents");

        System.out.println(hogwarts.getSpellEventById(3));
        System.out.println(hogwarts.getSpellEventsByType("Защита"));
    }
}
