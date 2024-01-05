package faang.school.godbless.done.character;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int enemyHealthLeft = (character.getHealth() - getAgility());

        character.setHealth(enemyHealthLeft);
    }
}
