package school.faang.task_57187;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Бомбарда", "Взрывающие препятствие");
        hogwartsSpells.addSpellEvent("Экспиллиармус", "Защитное заклинание");
        hogwartsSpells.addSpellEvent("Тергео", "Очищает предмет от пыли");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.getSpellEventsByType("Экспиллиармус");
        hogwartsSpells.getSpellEventsByType("Энгоргио");

        hogwartsSpells.deleteSpellEvent(2);

        hogwartsSpells.printAllSpellEvents();
    }
}
