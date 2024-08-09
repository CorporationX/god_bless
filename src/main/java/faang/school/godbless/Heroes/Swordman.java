package faang.school.godbless.Heroes;

public class Swordman extends Creature{
    public Swordman() {
        super("Swordman", 2, 6, 7, 5);
    }

    @Override
    public int getDamage() {
        return getAttack() * 3;
    }
}
