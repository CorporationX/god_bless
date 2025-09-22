package school.faang.handlers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Чар", "Защищает от атак");
        hogwartsSpells.addSpellEvent("Трансфигурация", "Преобразует предмет");
        hogwartsSpells.addSpellEvent("Защита", "Сильный барьер");

        //Печатаем все события в консоль
        System.out.println("Все события:");
        hogwartsSpells.printAllSpellEvents();

        //Получаем событие по его id
        System.out.println("\nСобытие с id '2':");
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(2);
        if (spellEvent != null) {
            System.out.println(spellEvent);
        }

        //Получаем события по типу
        System.out.println("\nСобытия типа 'Чар'");
        List<SpellEvent> events = hogwartsSpells.getSpellEventsByType("Чар");
        for (SpellEvent event : events) {
            System.out.println(event);
        }

        //Удаляем событие по id
        System.out.println("\nУдаляем событие с id '1'");
        hogwartsSpells.deleteSpellEvent(1);

        //Печать всех событий
        System.out.println("\nВсе события после удаления:");
        hogwartsSpells.printAllSpellEvents();
    }
}