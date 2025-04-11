package school.faang.spells;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Левитация");
        hogwartsSpells.addSpellEvent("Чары", "Дыхание под водой");
        hogwartsSpells.addSpellEvent("Чары", "Хождение по лаве");
        hogwartsSpells.addSpellEvent("Защита", "Защита от заклинаний");
        hogwartsSpells.addSpellEvent("Защита", "Защита от физических атак");
        hogwartsSpells.addSpellEvent("Чары", "Невидимость");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразование предмета");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Анимагия");
        hogwartsSpells.addSpellEvent("Атакующие Чары", "Взрыв");
        hogwartsSpells.addSpellEvent("Атакующие Чары", "Дуговая молния");
        hogwartsSpells.addSpellEvent("Атакующие Чары", "Огненный шар");

        hogwartsSpells.printAllSpellEvents();

        log.info(hogwartsSpells.getSpellEventById(10).toString());
        log.info(hogwartsSpells.getSpellEventByType("Чары").toString());

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
