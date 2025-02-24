package ru.maks1979.task_44628;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells spells = new HogwartsSpells();

        spells.spellById = new HashMap<>();
        spells.spellByType = new HashMap<>();


        spells.addSpellEvent(1, "Protection", "Shield creating");
        spells.addSpellEvent(2, "Attack", "Fireball attack");
        spells.addSpellEvent(3, "Healing", "Healing spell");
        spells.addSpellEvent(4, "Attack", "Ice shard attack");

        System.out.println(spells.getSpellEventById(2));

        List<SpellEvent> offensiveSpells = spells.getSpellEventsByType("Offensive");
        System.out.println(offensiveSpells);

        spells.deleteSpellEvent(3);
        List<SpellEvent> healingSpells = spells.getSpellEventsByType("Healing");
        System.out.println(healingSpells);


        spells.addSpellEvent(5, "Offensive", "Lightning bolt attack");
        System.out.println(offensiveSpells);

    }
}

