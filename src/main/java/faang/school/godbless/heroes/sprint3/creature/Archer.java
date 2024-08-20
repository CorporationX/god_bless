package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;

@Getter
public class Archer extends Creature {
    private final String name = "archer";
    private final int power = 10;

    public Archer(int quantity) {
        super(quantity);
    }
}
