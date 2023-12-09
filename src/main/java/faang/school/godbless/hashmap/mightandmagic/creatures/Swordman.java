package faang.school.godbless.hashmap.mightandmagic.creatures;

public class Swordman extends Creature {

    private static final String NAME = "Swordman";
    private static final int LEVEL = 3;
    private static final int ATTACK = 10;
    private static final int DEFENSE = 6;
    private static final int SPEED = 5;
    private static final int HP = 50;

    public Swordman(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, HP, quantity);
    }

}
