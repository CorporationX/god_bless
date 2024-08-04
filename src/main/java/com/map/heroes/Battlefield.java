package com.map.heroes;

import com.map.heroes.heroes.Hero;
import com.map.heroes.units.*;

import java.util.Map;

public class Battlefield {
    public static void main(String[] args) {


        Hero edric = new Hero(" Edric", "Human", 100, 10);
        Hero cyra = new Hero("Cyra", "Magicians", 200, 9);

        Creature angel = new Angel("Angel", 7, 20, 20, 12, 200, 10);
        Creature griffin = new Griffin("Griffin", 3, 8, 8, 6, 25, 100);
        Creature swordman = new Swordman("Swordman", 4, 10, 12, 5, 35, 50);
        Creature pikeman = new Pikeman("Pikeman", 1, 4, 5, 4, 10, 200);

        edric.addCreature(angel, 7);
        edric.addCreature(griffin, 40);
        edric.addCreature(swordman, 20);
        edric.addCreature(pikeman, 100);

        cyra.addCreature(angel, 3);
        cyra.addCreature(griffin, 60);
        cyra.addCreature(swordman, 30);
        cyra.addCreature(pikeman, 100);
        System.out.println( battle(edric,cyra));

    }

    public static String battle(Hero heroOne, Hero heroTwo) {
        return strengthArmy(heroOne) > strengthArmy(heroTwo) ? "Winner: " + heroOne.getName()
                : "Winner: " + heroTwo.getName();
    }
    public static Integer strengthArmy (Hero hero){
        int totalDmg = 0;
        int totalHealth = 0;
        int totalArmor =0 ;
        int totalSpeed =0;
        for (Map.Entry<Creature, Integer> entry : hero.getCreaturesMap().entrySet()){
            totalDmg += entry.getKey().getDamage() * entry.getValue();
            totalHealth += entry.getKey().getHealth() * entry.getValue();
            totalArmor += entry.getKey().getArmor() * entry.getValue();
            totalSpeed += entry.getKey().getSpeed() * entry.getValue();
        }
        return totalDmg + totalHealth + totalArmor + totalSpeed;
    }


}
