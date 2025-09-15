package school.faang.rpg.game.characters;

public class Warrior extends Character {

    public static final Integer STRENGTH = 10;
    public static final Integer AGILITY = 5;
    public static final Integer INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.getStrength());
    }
}
