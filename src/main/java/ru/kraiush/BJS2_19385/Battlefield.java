package ru.kraiush.BJS2_19385;

import java.util.Map;

public class Battlefield {

    static String battl(Map<Creature, Integer> mapHeroes, Map<Creature, Integer> mapScoundrels) {

        int armyHeroes = 0;
        int armyScoundrels = 0;

        for (Map.Entry<Creature, Integer> item : mapHeroes.entrySet()) {
            armyHeroes = (item.getKey().getLevel() + item.getKey().getAttack() + item.getKey().getDefense() + item.getKey().getRate()) * item.getValue();
        }

        for (Map.Entry<Creature, Integer> item : mapScoundrels.entrySet()) {
            armyScoundrels = (item.getKey().getLevel() + item.getKey().getAttack() + item.getKey().getDefense() + item.getKey().getRate()) * item.getValue();
        }

        System.out.println("   ---- Might of army of Heroes: " + armyHeroes);
        System.out.println("   ---- Might of army of Scoundrels: " + armyScoundrels);

        if (armyHeroes >= armyScoundrels) {
            return "\nArmy of Heroes won!";
        } else {
            return "\nArmy of Heroes won!";
        }
    }
}
