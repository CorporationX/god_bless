package school.faang.javacore.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(
                name,
                HeroesCharacteristics.ARCHER_DEFAULT_STRENGTH.getValue(),
                HeroesCharacteristics.ARCHER_DEFAULT_DEXTERITY.getValue(),
                HeroesCharacteristics.ARCHER_DEFAULT_INTELLIGENCE.getValue());
    }

    @Override
    void attack(Character opponent) {
        reduceHealth(opponent, this.getDexterity());
    }
}
