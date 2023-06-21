package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY,INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.health <= 0){
            character.health = 0;
            throw new RuntimeException(character.name + " is dead");
        } else {
            character.health -= this.strength;
        }

    }
}
