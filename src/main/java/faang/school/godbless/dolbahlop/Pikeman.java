package faang.school.godbless.dolbahlop;

public class Pikeman extends Creature {
    private static final String NAME = "Pikeman";
    private static final int LEVEL = 10;
    private static final int ATTACK = 50;
    private static final int DEFENSE = 50;
    private static final int SPEED = 40;

    public Pikeman(int quantity){
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, quantity);
    }
}
