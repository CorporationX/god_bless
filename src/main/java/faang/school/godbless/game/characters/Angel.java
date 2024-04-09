package faang.school.godbless.game.characters;

import faang.school.godbless.game.Creature;

public class Angel extends Creature {
    public Angel(int quantity) {
        super("Angel", 1, 3, 3, 10, quantity);
    }

    @Override
    public int getDamage() {
        return getQuantity() * 3;
    }
}
