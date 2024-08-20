package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;

@Getter
public class Mage extends Creature {
    private final String name = "mage";
    private final int power = 15;

    public Mage(int quantity) {
        super(quantity);
    }
}
