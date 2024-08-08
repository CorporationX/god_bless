package faang.school.godbless.battle;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@ToString
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

    public void increaseLevel(){
        this.level++;
    }

    public void checkArmy(){
        army.removeIf(creature -> creature.getHealth() <= 0);
    }

    public void printArmy(){
        System.out.println(name + "`s army: " + Arrays.toString(army.toArray()));
    }
}
