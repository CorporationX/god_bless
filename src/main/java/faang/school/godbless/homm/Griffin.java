package faang.school.godbless.homm;

public class Griffin extends Creature{

    private final int ATTACK;
    private final int DEFENCE;
    private final int SPEED;

    public Griffin(String name, int lvl) {
        super(10, 10, 5, name, lvl, 0);
        this.ATTACK = 10;
        this.DEFENCE = 10;
        this.SPEED = 5;
    }

    @Override
    public boolean getDamage(Creature creature) {
        int isAlive = (creature.getDEFENCE() * creature.getSPEED()) - this.ATTACK ;
        return isAlive >= 0;
    }
}
