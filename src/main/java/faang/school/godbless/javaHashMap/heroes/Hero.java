package faang.school.godbless.javaHashMap.heroes;

import faang.school.godbless.javaHashMap.heroes.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;

    private List<Creature> army;

    public Hero(String name, String fraction, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.lvl = lvl;

        army = new ArrayList<>();
    }

    /*public void addCreature(Creature creature, int quantity) {
        if(army.contains(creature)) {

        }
        army.add()
    }*/
}
