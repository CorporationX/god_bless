package school.faang.task57058;

import school.faang.task57058.service.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        //SpellEvent defense = new SpellEvent("Защита", "создает силовое поле");
        //SpellEvent attack = new SpellEvent("Нападение", "добавляет силу для атаки");

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Защита", "создает силовое поле");
        hogwartsSpells.addSpellEvent("Нападение", "добавляет силу для атаки");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("===================");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("===================");
        System.out.println(hogwartsSpells.getSpellEventById(1));

    }
}