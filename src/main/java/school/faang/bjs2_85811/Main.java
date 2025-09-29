package school.faang.bjs2_85811;

import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent("Чар", "Фаербол");
        spells.addSpellEvent("Защита", "Защищает от атак");
        spells.addSpellEvent("Чар", "Преобразует предмет");

        try {
            System.out.println("-----------------Print all events--------------------");
            spells.printAllSpellEvents();

            System.out.println("-----------------Find spell by ID--------------------");
            System.out.println(spells.getSpellEventById(1));
            System.out.println(spells.getSpellEventById(3));

            System.out.println("-----------------Find spell by type------------------");
            System.out.println(spells.getSpellEventsByType("Защита"));

            System.out.println("-----------------Delete spell------------------------");
            spells.deleteSpellEvent(2);
            spells.printAllSpellEvents();

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
