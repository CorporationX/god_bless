package faang.school.godbless.heroesOfMagic;

public class Swordman extends Creature{
    public Swordman(Integer quantity) {
        super("swordman", 5, 10, 3, 5, quantity);
    }

    @Override
    public Integer getDamage() {
        return super.getDamage();
    }

    @Override
    public Creature createInstance(Integer quantity) {
        return new Swordman(quantity);
    }
}
