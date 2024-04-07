package faang.school.godbless.homm;


public class Pikeman extends Creature{
    private final int ATTACK;
    private final int DEFENCE;
    private final int SPEED;

    public Pikeman(String name, int lvl) {
        super(15, 3, 10, name, lvl, 0);
        this.ATTACK = 15;
        this.DEFENCE = 3;
        this.SPEED = 10;
    }

    @Override
    public boolean getDamage(Creature creature) {
        int isAlive = (creature.getDEFENCE() * creature.getSPEED()) - this.ATTACK ;
        return isAlive >= 0;
    }
}
