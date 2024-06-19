package faang.school.godbless.HeroesOfMightAndMagic;

public class Mage extends Unit {
    private final int DAMAGE_ONE_MAGE = 7;

    public Mage(int amountPeople) {
        super(amountPeople);
    }

    public int getDamage() {
        return DAMAGE_ONE_MAGE;
    }
}
