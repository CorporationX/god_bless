package school.faang.rpg.game.characters;

public class Archer extends Character {

    public static final Integer STRENGTH = 3;
    public static final Integer AGILITY = 10;
    public static final Integer INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.getAgility());
    }
}
