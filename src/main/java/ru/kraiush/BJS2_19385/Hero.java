package ru.kraiush.BJS2_19385;

import lombok.Getter;

import java.util.Map;

@Getter
public class Hero {

    String name;
    String fraction;
    int experience;
    int level;

    public static Map<Creature, Integer> addCreature(Creature origin, Integer quantity, Map<Creature, Integer> mapHeroes) {

        if ("angel".equals(origin.getType())) {
            Creature angel = new Angel(origin.getType(), origin.getLevel(), origin.getAttack(), origin.getDefense(), origin.getRate());
            mapHeroes.put(angel, quantity);
            return mapHeroes;
        }
        if ("griffin".equals(origin.getType())) {
            Creature griffin = new Griffin(origin.getType(), origin.getLevel(), origin.getAttack(), origin.getDefense(), origin.getRate());
            mapHeroes.put(griffin, quantity);
            return mapHeroes;
        }
        if ("pikeman".equals(origin.getType())) {
            Creature pikeman = new Pikeman(origin.getType(), origin.getLevel(), origin.getAttack(), origin.getDefense(), origin.getRate());
            mapHeroes.put(pikeman, quantity);
            return mapHeroes;
        }
        if ("swordman".equals(origin.getType())) {
            Creature swordman = new Swordman(origin.getType(), origin.getLevel(), origin.getAttack(), origin.getDefense(), origin.getRate());
            mapHeroes.put(swordman, quantity);
            return mapHeroes;
        }
        return null;
    }

    public static void removeCreature(Creature origin, int amount, Map<Creature, Integer> mapHeroes) {
        for (Map.Entry<Creature, Integer> item : mapHeroes.entrySet()) {
            if (item.getKey().getType().equals(origin.getType()) &&
                item.getValue().equals(amount)) {
                mapHeroes.remove(item.getKey());
                break;
            }
        }
    }
}
