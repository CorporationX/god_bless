package faang.school.godbless.BJS2_511.creatures;

public class Swordman extends Creature{
    public static final String SWORDMAN_DEFAULT_NAME = "Swordman";
    public static final int SWORDMAN_DEFAULT_LEVEL = 4;
    public static final int SWORDMAN_DEFAULT_DAMAGE = 4;
    public static final int SWORDMAN_DEFAULT_DEFENSE = 4;
    public static final int SWORDMAN_DEFAULT_SPEED = 4;
    public static final int SWORDMAN_DEFAULT_QUANTITY = 4;
    public Swordman(int quantity) {
        super(SWORDMAN_DEFAULT_NAME, SWORDMAN_DEFAULT_LEVEL, SWORDMAN_DEFAULT_DAMAGE, SWORDMAN_DEFAULT_DEFENSE, SWORDMAN_DEFAULT_SPEED
                , quantity);
    }
}
