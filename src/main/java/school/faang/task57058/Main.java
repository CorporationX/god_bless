package school.faang.task57058;

import school.faang.task57058.service.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
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