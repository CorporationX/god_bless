package faang.school.godbless.characters;

public class Warrior extends Character {
    public static final int DEFAULT_FORCE = 10;
    public static final int DEFAULT_AGILITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_FORCE, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.decreaseHealth(this.getForce());
    }

}
