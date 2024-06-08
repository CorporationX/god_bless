package faang.school.godbless.heroesOfMagic;

public class Angel extends Creature{

    public Angel(Integer quantity) {
        super("angel", 10, 12, 10, 5, quantity);
    }

    @Override
    public Integer getDamage() {
        return super.getDamage();
    }

    @Override
    public Creature createInstance(Integer quantity) {
        return new Angel(quantity);
    }
}
