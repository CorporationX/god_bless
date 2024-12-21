package derschrank.sprint01.task07.bjstwo_44435;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        Random rnd = new Random();
        Spell[] spells = Spell.values();
        for (int i = 0; i < 20; i++) {
            int rndNumberOfSpell = rnd.nextInt(spells.length);
            hogwartsSpells.addSpellEvent(spells[rndNumberOfSpell]);
        }

        hogwartsSpells.printAllSpellEvents();

        int halfOfSizeOfSpellsLog = hogwartsSpells.getSize() / 2;
        for (int i = 0; i < halfOfSizeOfSpellsLog; i++) {
            hogwartsSpells.deleteSpellEvent(halfOfSizeOfSpellsLog / 2 + i);
        }

        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        hogwartsSpells.addSpellEvent(Spell.ALOHOMORA);
        hogwartsSpells.printAllSpellEventsByType(Spell.ALOHOMORA);
        System.out.println();

        hogwartsSpells.addSpellEvent(Spell.ACCIO);
        hogwartsSpells.printAllSpellEventsByType(Spell.ACCIO);
        System.out.println();

        hogwartsSpells.addSpellEvent(Spell.TARANTALLEGRA);
        hogwartsSpells.printAllSpellEventsByType(Spell.TARANTALLEGRA);
        System.out.println();



    }
}
