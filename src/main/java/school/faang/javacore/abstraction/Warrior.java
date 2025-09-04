package school.faang.javacore.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(
                name,
                HeroesCharacteristics.WARRIOR_DEFAULT_STRENGTH,
                HeroesCharacteristics.WARRIOR_DEFAULT_DEXTERITY,
                HeroesCharacteristics.WARRIOR_DEFAULT_INTELLIGENCE);
    }

    @Override
    protected void attack(Character opponent) {
        super.reduceHealth(opponent, this.getStrength());
    }
}
