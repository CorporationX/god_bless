package faang.school.godbless.BJS2_511.creatures;

public class Swordman extends Creature {
    public static final String SWORDMAN_DEFAULT_NAME = "Swordman";
    public static final int SWORDMAN_DEFAULT_LEVEL = 40;
    public static final int SWORDMAN_DEFAULT_ATTACK = 40;
    public static final int SWORDMAN_DEFAULT_DEFENSE = 40;
    public static final int SWORDMAN_DEFAULT_SPEED = 40;

    public Swordman(int quantity) {
        super(SWORDMAN_DEFAULT_NAME, SWORDMAN_DEFAULT_LEVEL, SWORDMAN_DEFAULT_ATTACK, SWORDMAN_DEFAULT_DEFENSE, SWORDMAN_DEFAULT_SPEED, quantity);
    }

    public Swordman(int quantity, String name) {
        super(name, SWORDMAN_DEFAULT_LEVEL, SWORDMAN_DEFAULT_ATTACK, SWORDMAN_DEFAULT_DEFENSE, SWORDMAN_DEFAULT_SPEED, quantity);
    }
}
