package faang.school.godbless;

public class Swordman extends Creature{

    private final int SWORDMAN_LEVEL = 1;
    private final int SWORDMAN_DAMAGE = 7;
    private final int SWORDMAN_PROTECTION = 70;
    private final int SWORDMAN_SPEED = 5;
    private final int SWORDMAN_QUANTITY = 1000;

    public Swordman(String name){
        super(name);
        this.level = SWORDMAN_LEVEL;
        this.damage = SWORDMAN_DAMAGE;
        this.protection = SWORDMAN_PROTECTION;
        this.speed = SWORDMAN_SPEED;
        this.quantity = SWORDMAN_QUANTITY;
    }

    @Override
    public int getDamage(){
        return this.damage * quantity;
    }
}
