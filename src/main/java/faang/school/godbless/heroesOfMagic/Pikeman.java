package faang.school.godbless.heroesOfMagic;

public class Pikeman extends Creature{
    public Pikeman(Integer quantity) {
        super("pikeman", 3, 13, 2, 5, quantity);
    }

    @Override
    public Integer getDamage() {
        return super.getDamage();
    }

    @Override
    public Creature createInstance(Integer quantity) {
        return new Pikeman(quantity);
    }
}
