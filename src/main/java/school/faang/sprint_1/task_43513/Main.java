package school.faang.sprint_1.task_43513;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Трансфигурация", "Изменение внешности");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Возвращение в исходнкю форму");
        hogwartsSpells.addSpellEvent(3, "Чары", "Левитация");
        hogwartsSpells.addSpellEvent(4, "Исцеление", "Вылечить порез");

        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
        System.out.println();

        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println(hogwartsSpells.getSpellEventsByType("Трансфигурация"));
    }
}
