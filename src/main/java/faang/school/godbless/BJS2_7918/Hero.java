package faang.school.godbless.BJS2_7918;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> heroArmy = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature) {
        heroArmy.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {}
}
