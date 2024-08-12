package faang.school.godbless.java.sql.heroes;


public class Pikeman extends Creature {
    public final static String NAME = "Pikeman";
    public final static int LEVEL = 1;
    public final static int ATTACK = 5;
    public final static int PROTECT = 2;
    public final static int SPEED = 5;

    public Pikeman() {
        this.name = Pikeman.NAME;
        this.level = Pikeman.LEVEL;
        this.attack = Pikeman.ATTACK;
        this.protect = Pikeman.PROTECT;
        this.speed = Pikeman.SPEED;
    }
}
