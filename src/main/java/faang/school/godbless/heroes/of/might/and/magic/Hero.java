package faang.school.godbless.heroes.of.might.and.magic;

import faang.school.godbless.heroes.of.might.and.magic.creatures.Creature;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NonNull
@Getter
@Setter
public class Hero {
    private List<Creature> squadCreature;
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public Hero(String name, String fraction, int experience, int level) {
        this.squadCreature = new ArrayList<>();
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            squadCreature.add(creature);
        }
    }

    public void removeCreature() {
        squadCreature.remove(0);
    }

}
