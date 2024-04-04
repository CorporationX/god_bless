package faang.school.godbless.geroesofmightandmagic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Hero {
    private final List<Creature> ARMY = new ArrayList<>();

    private final String name;
    private final String fraction;
    private int experience;
    private int level;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setCount(quantity);
        ARMY.add(creature);
    }

    public int removeCreature(Creature creature, int quantity) {
        int experience = creature.getLevel() * quantity;
        creature.setCount(creature.getCount() - quantity);
        if (creature.getCount() <= 0) {
            ARMY.remove(creature);
        } else {
            ARMY.remove(creature);
        }
        return experience;
    }

    public List<Creature> getArmy() {
        return ARMY;
    }

    public void setExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            int levelChange = this.experience/100;
            this.experience -= levelChange*100;
            this.level += levelChange;
            System.out.println(name + " " + levelChange + " level up");
        }
    }

    public void printArmy() {
        System.out.println(name + "`s army");
        ARMY.forEach(System.out::println);
    }
}
