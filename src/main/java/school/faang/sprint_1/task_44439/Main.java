package school.faang.sprint_1.task_44439;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        System.out.println("Заклинания добавляются в библиотеку...");
        hogwartsSpells.addSpellEvent(1, "Чар", "Поднимает предметы");
        hogwartsSpells.addSpellEvent(2, "Защита", "Создает защитное поле");
        hogwartsSpells.addSpellEvent(3, "Атака", "Дает увечье");
        System.out.print("\n");
        System.out.println("Печать всех заклинаний");
        hogwartsSpells.printAllSpellEvents();
        System.out.print("\n");
        System.out.println("Отображение заклинания по id");
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.print("\n");
        System.out.println("Отображение заклинания по type: Атака");
        System.out.println(hogwartsSpells.getSpellEventByType("Атака"));
        System.out.print("\n");
        System.out.println("Удаление заклинания по id: 1");
        hogwartsSpells.deleteSpellEvent(1);
        System.out.print("\n");
        System.out.println("Печать всех заклинаний");
        hogwartsSpells.printAllSpellEvents();

    }
}
