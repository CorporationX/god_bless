package faang.school.godbless.HeroesOfMightAndMagic;

public class Swordsman extends Unit {
    private final int DAMAGE_ONE_SWORDSMAN = 15;

    public Swordsman(int amountPeople) {
        super(amountPeople);
    }

    public int getDamage() {
        return DAMAGE_ONE_SWORDSMAN;
    }
}
