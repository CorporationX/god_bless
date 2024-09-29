package ru.kraiush.BJS2_19385;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppHeroes_of_Might_and_Magic {

    public static void main(String[] args) throws InterruptedException {

        Creature angel= new Angel("angel", 21, 5, 7, 15);
        Creature griffin= new Griffin("griffin", 21, 3, 3, 9);
        Creature pikeman= new Pikeman("pikeman", 17, 9, 14, 6);
        Creature swordman= new Swordman("swordman", 11, 19, 17, 10);

        Map<Creature, Integer>  mapArmyOfHeroes= new HashMap<>();
        
        Hero.addCreature(angel,10, mapArmyOfHeroes);
        Hero.addCreature(pikeman,25, mapArmyOfHeroes);
        Hero.addCreature(swordman,15, mapArmyOfHeroes);
        mapArmyOfHeroes.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        System.out.println("\nremove <pikeman>");
        Hero.removeCreature (pikeman, 25, mapArmyOfHeroes);
        mapArmyOfHeroes.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        Map<Creature, Integer>  mapArmyOfScoundrels= new HashMap<>();
        Hero.addCreature(griffin,13, mapArmyOfScoundrels);
        Hero.addCreature(pikeman,15, mapArmyOfScoundrels);

        System.out.println("\nButtle between Heroes and Scoundrels begin");

        Thread.sleep(4000);

        String resultOfButtle= Battlefield.battl(mapArmyOfHeroes, mapArmyOfScoundrels);
        System.out.println(resultOfButtle);;
    }
}
