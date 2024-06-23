package faang.school.godbless;

public class Pikeman extends Creature{

    private final int PIKEMAN_LEVEL = 1;
    private final int PIKEMAN_DAMAGE = 10;
    private final int PIKEMAN_PROTECTION = 50;
    private final int PIKEMAN_SPEED = 7;
    private final int PIKEMAN_QUANTITY = 1;

    public Pikeman(String name){
        super(name);
        this.level = PIKEMAN_LEVEL;
        this.damage = PIKEMAN_DAMAGE;
        this.protection = PIKEMAN_PROTECTION;
        this.speed = PIKEMAN_SPEED;
        this.quantity = PIKEMAN_QUANTITY;
    }

    @Override
    public int getDamage(){
        return this.damage * quantity;
    }
}
