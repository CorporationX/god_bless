package school.faang.javacore.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(
                name,
                HeroesCharacteristics.WARRIOR_DEFAULT_STRENGTH.getValue(),
                HeroesCharacteristics.WARRIOR_DEFAULT_DEXTERITY.getValue(),
                HeroesCharacteristics.WARRIOR_DEFAULT_INTELLIGENCE.getValue());
    }

    @Override
    void attack(Character opponent) {
        reduceHealth(opponent, this.getStrength());
    }
}
