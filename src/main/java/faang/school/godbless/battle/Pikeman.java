package faang.school.godbless.battle;

public class Pikeman extends Creature{

    public Pikeman(String name) {
        super(name);
        attack = 10;
        defense = 10;
        speed = 2;
    }

    @Override
    public int getDamage() {
        int n = 1;
        return attack + speed * n;
    }

    @Override
    public String toString() {
        return "Pikeman (health=" + getHealth() + ")";
    }
}
