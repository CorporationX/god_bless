package faang.school.godbless.dolbahlop;

public class Swordman extends Creature {
    private static final String NAME = "Swordman";
    private static final int LEVEL = 30;
    private static final int ATTACK = 100;
    private static final int DEFENSE = 120;
    private static final int SPEED = 5;

    public Swordman(int quantity){
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }
}
