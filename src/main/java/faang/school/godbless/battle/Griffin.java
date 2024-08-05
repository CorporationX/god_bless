package faang.school.godbless.battle;

public class Griffin extends Creature{
    private final int N = 2;

    public Griffin(String name) {
        super(name);
        attack = 15;
        defense = 5;
        speed = 3;
    }

    @Override
    public int getDamage() {
        return attack + speed * N;
    }
}
