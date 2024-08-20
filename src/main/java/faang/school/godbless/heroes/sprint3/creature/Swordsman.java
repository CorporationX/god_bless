package faang.school.godbless.heroes.sprint3.creature;

import lombok.Getter;

@Getter
public class Swordsman extends Creature {
    private final String name = "swordsman";
    private final int power = 30;

    public Swordsman(int quantity) {
        super(quantity);
    }
}
