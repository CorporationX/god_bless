package faang.school.godbless;

public class Angel  extends Creature{

    private final int ANGEL_LEVEL = 1;
    private final int ANGEL_DAMAGE = 7;
    private final int ANGEL_PROTECTION = 70;
    private final int ANGEL_SPEED = 5;
    private final int ANGEL_QUANTITY = 1000;

    public Angel(String name) {
        super(name);
        this.level = ANGEL_LEVEL;
        this.damage = ANGEL_DAMAGE;
        this.protection = ANGEL_PROTECTION;
        this.speed = ANGEL_PROTECTION;
        this.quantity = ANGEL_QUANTITY;
    }

    @Override
    public int getDamage(){
        return this.damage * quantity;
    }
}
