package faang.school.godbless.hashmap.mightandmagic.creatures;

public class Angel extends Creature {

    private static final String NAME = "Angel";
    private static final int LEVEL = 4;
    private static final int ATTACK = 15;
    private static final int DEFENSE = 10;
    private static final int SPEED = 7;
    private static final int HP = 100;

    public Angel(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, HP, quantity);
    }

}
