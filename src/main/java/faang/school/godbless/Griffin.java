package faang.school.godbless;

public class Griffin extends Creature{

    private final int GRIFFIN_LEVEL = 1;
    private final int GRIFFIN_DAMAGE = 15;
    private final int GRIFFIN_PROTECTION = 30;
    private final int GRIFFIN_SPEED = 10;
    private final int GRIFFIN_QUANTITY = 1;

    public Griffin(String name){
        super(name);
        this.level = GRIFFIN_LEVEL;
        this.damage = GRIFFIN_DAMAGE;
        this.protection = GRIFFIN_PROTECTION;
        this.speed = GRIFFIN_SPEED;
        this.quantity = GRIFFIN_QUANTITY;
    }

    @Override
    public int getDamage(){
        return this.damage * quantity;
    }
}
