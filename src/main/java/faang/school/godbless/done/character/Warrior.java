package faang.school.godbless.done.character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int enemyHealthLeft = (character.getHealth() - getStrength());

        character.setHealth(enemyHealthLeft);
    }
}
