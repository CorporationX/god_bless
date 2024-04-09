package faang.school.godbless.game.characters;

import faang.school.godbless.game.Creature;

public class Pikeman extends Creature {
    public Pikeman(int quantity) {
        super("Pikeman", 4, 7, 4, 6, quantity);
    }

    @Override
    public int getDamage() {
        return getQuantity() * 4;
    }
}
