package school.fang.bjs2_68665;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.setSpellsByType(new HashMap<>());
        hogwartsSpells.setSpellById(new HashMap<>());

        hogwartsSpells.addSpellEvent("Defence", "Defence from attacks");
        hogwartsSpells.addSpellEvent("Fire", "Hurls fireball at opponent");
        hogwartsSpells.addSpellEvent("IceWall", "Builds a wall of ice");
        hogwartsSpells.addSpellEvent("Metal", "Turns anything into gold");

        hogwartsSpells.printAllSpellEvents();

        System.out.println("--------GETTING SPELL BY TYPE \"Defence\"--------");
        System.out.println(hogwartsSpells.getSpellByType("Defence"));

        System.out.println("--------GETTING SPELLEVENT BY ID 3--------");
        System.out.println(hogwartsSpells.getSpellEventById(3));

        System.out.println("--------DELETING SPELLEVENT BY ID--------");
        hogwartsSpells.deleteSpellEvent(2);
        try {
            System.out.println(hogwartsSpells.getSpellEventById(2));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
