package faang.school.godbless.heroesOfMagic;

public class Griffin extends Creature{
    public Griffin(Integer quantity) {
        super("griffin", 4, 8, 4, 5, quantity);
    }

    @Override
    public Integer getDamage() {
        return super.getDamage();
    }

    @Override
    public Creature createInstance(Integer quantity) {
        return new Griffin(quantity);
    }
}
