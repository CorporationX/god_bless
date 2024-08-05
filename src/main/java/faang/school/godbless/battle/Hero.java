package faang.school.godbless.battle;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
public class Hero {
    private String name;
    private int level = 1;
    private List<Creature> army;

    public Hero(String name) {
        this.name = name;
        this.army = new LinkedList<>();
    }

    public void addCreature(Creature creature, int quantity){
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity){
        for (int i = 0; i < quantity; i++) {
            army.remove(creature);
        }
    }
}
