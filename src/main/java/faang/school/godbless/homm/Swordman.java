package faang.school.godbless.homm;

public class Swordman extends Creature{

    private final int ATTACK;
    private final int DEFENCE;
    private final int SPEED;

    public Swordman(String name, int lvl) {
        super(10, 10, 7, name, lvl, 0);
        this.ATTACK = 10;
        this.DEFENCE = 10;
        this.SPEED = 7;
    }

    @Override
    public boolean getDamage(Creature creature) {
        int isAlive = (creature.getDEFENCE() * creature.getSPEED()) - this.ATTACK ;
        return isAlive >= 0;
    }
}
