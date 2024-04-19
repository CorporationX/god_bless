package faang.school.godbless.heroes_of_mm;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Creature> creatures = new ArrayList<>();

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public int calculateTotalPower() {
        int totalPower = creatures.parallelStream()
                .mapToInt(Creature::getPower)
                .sum();
        return totalPower;
    }
}
