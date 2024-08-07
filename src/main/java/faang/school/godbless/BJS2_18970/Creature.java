package faang.school.godbless.BJS2_18970;

public abstract class Creature {
    private String name;
    private int hp;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity;
    private int damage;

    public Creature(String name, int level, int attack, int protection, int speed, int quantity) {
        this.name = name;
        this.hp = 100;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.quantity = quantity;
    }

    public abstract int getDamage();

    public void kick(int damage){
        this.hp -= damage;
    }

    public boolean isDead(){
        return hp <= 0;
    }
}
