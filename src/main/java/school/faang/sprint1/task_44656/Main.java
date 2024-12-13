package school.faang.sprint1.task_44656;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent(1, "Чар", "Создает защитный барьер");
        spells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет в другое");
        spells.addSpellEvent(3, "Защита", "Отражает атакующие заклинания");
        spells.addSpellEvent(4, "Чар", "Позволяет летать на метле");

        System.out.println("Получение заклинания по ID (1):");
        System.out.println(spells.getSpellEventById(1));

        System.out.println("\nПолучение заклинания по ID (5):");
        System.out.println(spells.getSpellEventById(5));


        System.out.println("\nПолучение заклинаний по типу (Чар):");
        List<SpellEvent> charSpells1 = spells.getSpellEventsByType("Защита");
        System.out.println();
        System.out.println("\nПолучение заклинаний по типу (Чар):");
        List<SpellEvent> charSpells2 = spells.getSpellEventsByType("Защит");
        System.out.println();

        System.out.println("\nУдаление заклинания с ID (2):");
        spells.deleteSpellEvent(2);

        System.out.println("\nВсе заклинания после удаления:");
        spells.printAllSpellEvents();
    }
}

