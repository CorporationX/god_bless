package faang.school.godbless.Heroes;

public class Angel extends Creature{
    public Angel() {
        super("Angel", 7, 20, 20, 12);
    }

    @Override
    public int getDamage() {
        return getAttack() * 5;
    }
}
