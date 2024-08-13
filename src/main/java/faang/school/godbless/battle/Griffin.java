package faang.school.godbless.battle;

public class Griffin extends Creature{

    public Griffin(String name) {
        super(name);
        attack = 15;
        defense = 5;
        speed = 3;
    }

    @Override
    public int getDamage() {
        int n = 2;
        return attack + speed * n;
    }

    @Override
    public String toString() {
        return "Griffin (health=" + getHealth() + ")";
    }
}
