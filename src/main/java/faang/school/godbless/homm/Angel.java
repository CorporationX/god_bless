package faang.school.godbless.homm;

public class Angel extends Creature{

    private final int ATTACK;
    private final int DEFENCE;
    private final int SPEED;

    public Angel(String name, int lvl) {
        super(7, 15, 10, name, lvl, 0);
        this.ATTACK = 7;
        this.DEFENCE = 15;
        this.SPEED = 10;
    }

    @Override
    public boolean getDamage(Creature creature) {
        int isAlive = (creature.getDEFENCE() * creature.getSPEED()) - this.ATTACK ;
        return isAlive >= 0;
    }
}
