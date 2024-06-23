package faang.school.godbless.HeroesOfMightAndMagic;

public abstract class Unit {
    private final int amountPeople;

    public Unit(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    public int getAmountPeople() {
        return amountPeople;
    }

    public int getPowerSquad() {
        return getDamage() * getAmountPeople();
    }

    public abstract int getDamage();
}
