package faang.school.godbless.battle;

public class Angel extends Creature{

    public Angel(String name){
        super(name);
        attack = 13;
        defense = 6;
        speed = 1;
    }

    @Override
    public int getDamage() {
        int n = 4;
        return attack + speed * n;
    }

    @Override
    public String toString() {
        return "Angel (health=" + getHealth() + ")";
    }
}
