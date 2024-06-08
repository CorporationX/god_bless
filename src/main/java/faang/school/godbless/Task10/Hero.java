package faang.school.godbless.Task10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString

public class Hero {

    private static int MAX_CAPACITY = 5;
    private String name;
    private String fraction;
    private int exp;
    private int level;
    private List<Creature> army;

    public Hero(String name, String fraction, int exp, int level, List<Creature> army) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.level = level;
        this.army = new ArrayList<>(MAX_CAPACITY);
        this.army = army;
    }

    public void addToArmy(Creature creature, int quantity) {
        if (army.size() + quantity <= MAX_CAPACITY) {
            for (int i = 0; i < quantity; i++) {
                army.add(creature);
            }
        } else {
            throw new IllegalArgumentException("hero " + name + " has no slots");
        }
    }

    public void removeFromArmy(Creature creature) {
        army.remove(creature);
    }

}
