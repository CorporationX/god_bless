package school.faang.javacore.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(
                name,
                HeroesCharacteristics.ARCHER_DEFAULT_STRENGTH,
                HeroesCharacteristics.ARCHER_DEFAULT_DEXTERITY,
                HeroesCharacteristics.ARCHER_DEFAULT_INTELLIGENCE);
    }

    @Override
    protected void attack(Character opponent) {
        super.reduceHealth(opponent, this.getDexterity());
    }
}
