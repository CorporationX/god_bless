package faang.school.godbless.battle;

public class Swordman extends Creature{
    private final int N = 3;

    public Swordman(String name){
        super(name);
        attack = 7;
        defense = 10;
        speed = 4;
    }

    @Override
    public int getDamage() {
        return attack + speed * N;
    }
}
