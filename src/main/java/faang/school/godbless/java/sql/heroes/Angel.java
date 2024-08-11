package faang.school.godbless.java.sql.heroes;


public class Angel extends Creature {
    public final static String NAME = "Angel";
    public final static int LEVEL = 10;
    public final static int ATTACK = 75;
    public final static int PROTECT = 60;
    public final static int SPEED = 80;

    public Angel() {
        this.name = Angel.NAME;
        this.level = Angel.LEVEL;
        this.attack = Angel.ATTACK;
        this.protect = Angel.PROTECT;
        this.speed = Angel.SPEED;
    }
}
