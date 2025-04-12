package school.faang.spells;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(EventType.CHARMS, "Левитация");
        hogwartsSpells.addSpellEvent(EventType.CHARMS, "Дыхание под водой");
        hogwartsSpells.addSpellEvent(EventType.CHARMS, "Хождение по лаве");
        hogwartsSpells.addSpellEvent(EventType.DEFENCE, "Защита от заклинаний");
        hogwartsSpells.addSpellEvent(EventType.DEFENCE, "Защита от физических атак");
        hogwartsSpells.addSpellEvent(EventType.CHARMS, "Невидимость");
        hogwartsSpells.addSpellEvent(EventType.TRANSFIGURATION, "Преобразование предмета");
        hogwartsSpells.addSpellEvent(EventType.TRANSFIGURATION, "Анимагия");
        hogwartsSpells.addSpellEvent(EventType.ATTACK, "Взрыв");
        hogwartsSpells.addSpellEvent(EventType.ATTACK, "Дуговая молния");
        hogwartsSpells.addSpellEvent(EventType.ATTACK, "Огненный шар");

        hogwartsSpells.printAllSpellEvents();

        log.info(hogwartsSpells.getSpellEventById(10).toString());
        log.info(hogwartsSpells.getSpellEventByType(EventType.CHARMS).toString());

        hogwartsSpells.deleteSpellEvent(3);
        try {
            hogwartsSpells.deleteSpellEvent(3);
        } catch (NoSuchElementException e) {
            log.info("Ошибка: {}", e.toString());
        }

        try {
            log.info(hogwartsSpells.getSpellEventById(3).toString());
        } catch (NoSuchElementException e) {
            log.info("Ошибка: {}", e.toString());
        }
    }
}
