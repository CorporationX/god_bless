package faang.school.godbless.BJS2_7918;

import lombok.NoArgsConstructor;

public class Griffin extends Creature {

    public Griffin(int quantity) {
        super("Griffin", 1, 17, 10, 50, quantity);
    }

    @Override
    public int getDamage() {
        return attack * quantity;
    }

    public static Creature createCreature(int quantity) {
        return new Griffin(quantity);
    }
}
