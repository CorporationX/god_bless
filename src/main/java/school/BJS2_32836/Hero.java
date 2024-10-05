package school.BJS2_32836;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;

    private List<Creature> armia = new ArrayList<Creature>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            armia.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            armia.remove(creature);
        }
    }

    public List<Creature> getArmee() {
        return armia;
    }


}
