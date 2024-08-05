package faang.school.godbless.battle;

public class Pikeman extends Creature{
    private final int N = 1;

    public Pikeman(String name) {
        super(name);
        attack = 10;
        defense = 10;
        speed = 2;
    }

    @Override
    public int getDamage() {
        return attack + speed * N;
    }
}
