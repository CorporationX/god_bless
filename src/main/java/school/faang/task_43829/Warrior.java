package school.faang.task_43829;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 10;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.isDead()) {
            return;
        }
        character.health -= this.strength;
    }

}