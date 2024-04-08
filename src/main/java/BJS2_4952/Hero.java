package BJS2_4952;

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
    private String name;
    private String fraction;
    private int experience;
    private int level;

    void addCreature(Creature creature, int quantity) {
        ARMY.add(creature);
        creature.setCount(quantity);
    }

    void removeCreature(Creature creature, int damage) {
        if (creature.getHealthPoint() < damage) {
            creature.setCount(creature.getCount() - 1);
            System.out.println("Был убит 1 из отряда " + creature.getName());
            if (creature.getCount() <= 0) {
                ARMY.remove(creature);
                System.out.println(creature.getName() + " умер");
            }
        } else {
            creature.setHealthPoint(creature.getHealthPoint() - damage);
            System.out.println(creature.getName() + " получил " + damage + " урона");
        }
    }

    void giveExperience() {
        experience += 500;
        if (experience > 1000) {
            setLevel(getLevel() + 1);
            experience -= 1000;
        }
    }

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.experience = experience;
        this.level = level;
        this.fraction = fraction;
    }
}
