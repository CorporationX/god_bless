package faang.school.godbless.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {
    private final Random random = new Random();
    @Getter
    private final String name;
    @Getter
    private final List<Creature> army = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
    }

    public void addCreature(Creature creature) {
        army.add(creature);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public Creature getRandomCreature() {
        return army.get(random.nextInt(army.size()));
    }
}
