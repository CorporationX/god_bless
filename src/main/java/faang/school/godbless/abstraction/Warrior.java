package faang.school.godbless.abstraction;

public class Warrior extends Character {

    private String name;
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(STRENGTH, DEXTERITY,INTELLIGENCE);
        this.name = name;
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
