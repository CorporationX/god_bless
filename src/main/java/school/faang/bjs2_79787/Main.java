package school.faang.bjs2_79787;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells system = new HogwartsSpells();

        system.addSpellEvent("Чар", "Открывает двери");
        system.addSpellEvent("Защита", "Отражает атакующие заклинания");
        system.addSpellEvent("Трансфигурация", "Преобразует объект в другой");
        system.addSpellEvent("Защита", "Создаёт защитный купол");

        log.info("Получаем событие по ID = 2");
        SpellEvent eventById = system.getSpellEventById(2);
        log.info("Событие: {}", eventById);

        log.info("Получаем все события типа '{}'", "Защита");
        List<SpellEvent> defenseSpells = system.getSpellEventsByType("Защита");
        for (SpellEvent spell : defenseSpells) {
            log.info("{}", spell);
        }

        log.info("Удаляем событие с ID = 1");
        system.deleteSpellEvent(1);

        log.info("Печатаем все оставшиеся заклинания:");
        system.printAllSpellEvents();
    }
}
