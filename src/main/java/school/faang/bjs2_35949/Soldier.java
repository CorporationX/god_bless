package school.faang.bjs2_35949;

public abstract class Soldier {
    private int power;
    private int speed;
    private int health;
    private int attackRange;
    private int defence;

    public Soldier (int power,int speed,int health,int attackRange,int defence){
        this.power = power;
        this.attackRange = attackRange;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public int getPower(){
        return power;
    }
    public  int getSpeed(){
        return speed;
    }
    public int getHealth(){
        return health;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getDefence() {
        return defence;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public abstract void attack(Soldier target);
    public abstract void move(Soldier moveArea);
    public abstract void defend();
    public abstract void specialMove(Soldier target);

}
