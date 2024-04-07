package faang.school.godbless.game.characters;

import faang.school.godbless.game.Creature;

public class Griffin extends Creature {
    public Griffin(int quantity) {
        super("Griffin", 3, 5, 5, 5, quantity);
    }

    @Override
    public int getDamage() {
        return getQuantity() * 5;
    }
}
