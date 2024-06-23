package faang.school.godbless.HeroesOfMightAndMagic;

public class Archer extends Unit {
    private final int DAMAGE_ONE_ARCHER = 10;

    public Archer(int amountPeople) {
        super(amountPeople);
    }

    @Override
    public int getDamage() {
        return DAMAGE_ONE_ARCHER;
    }
}
