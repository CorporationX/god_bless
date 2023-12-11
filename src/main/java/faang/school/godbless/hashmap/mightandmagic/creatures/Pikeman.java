package faang.school.godbless.hashmap.mightandmagic.creatures;

public class Pikeman extends Creature {

    private static final String NAME = "Pikeman";
    private static final int LEVEL = 1;
    private static final int ATTACK = 5;
    private static final int DEFENSE = 3;
    private static final int SPEED = 4;
    private static final int HP = 10;

    public Pikeman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, HP, quantity);
    }

}
