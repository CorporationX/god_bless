package faang.school.godbless.battle;

public class Swordman extends Creature{

    public Swordman(String name){
        super(name);
        attack = 7;
        defense = 10;
        speed = 4;
    }

    @Override
    public int getDamage() {
        int n = 3;
        return attack + speed * n;
    }

    @Override
    public String toString() {
        return "Swordman (health=" + getHealth() + ")";
    }
}
