package school.faang.task_44522;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(1, "Защита", "Защищает от атак");
        HogwartsSpells.addSpellEvent(2, "Атака", "Атакует");
        HogwartsSpells.addSpellEvent(3, "Превратить", "Превращает");
        HogwartsSpells.addSpellEvent(4, "Открыть", "Открывает двери");
        HogwartsSpells.addSpellEvent(5, "Открыть", "Открывает портал");

        HogwartsSpells.printAllSpellEvents();
        HogwartsSpells.getSpellEventById(3);
        HogwartsSpells.getSpellEventsByType("Атака");
        HogwartsSpells.deleteSpellEvent(4);
        HogwartsSpells.printAllSpellEvents();
    }
}
