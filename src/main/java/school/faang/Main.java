package school.faang;

import school.faang.service.HogwartsSpells;
import school.faang.service.SpellEvent;

public class Main {
    public static void main(String[] args) {
        //SpellEvent defense = new SpellEvent("Защита", "создает силовое поле");
        //SpellEvent attack = new SpellEvent("Нападение", "добавляет силу для атаки");

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Защита", "создает силовое поле");
        hogwartsSpells.printAllSpellEvents();
        System.out.println();
        hogwartsSpells.addSpellEvent("Нападение", "добавляет силу для атаки");
        hogwartsSpells.printAllSpellEvents();


    }
}