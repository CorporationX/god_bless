package school.faang.task57212;

import school.faang.task57212.spells.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.getSpellEventsByType("Трансфигурация");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.addSpellEvent("Атака", "Огненная стрела");
        hogwartsSpells.addSpellEvent("Чары", "Полёт");
        hogwartsSpells.addSpellEvent("Атака", "Ледяная вспышка");
        hogwartsSpells.addSpellEvent("Защита", "Защитный купол");
        hogwartsSpells.addSpellEvent("Чары", "Невидимость");
        hogwartsSpells.addSpellEvent("Механическое", "Телекинез");
        hogwartsSpells.getSpellEventById(2);
        hogwartsSpells.getSpellEventById(10);
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.getSpellEventsByType("Атака");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(18);
    }
}
