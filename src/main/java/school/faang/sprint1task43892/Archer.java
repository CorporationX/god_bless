package school.faang.sprint1task43892;

public class Archer extends Character {
    public static final int STRENGTH = 3;
    public static final int AGILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}