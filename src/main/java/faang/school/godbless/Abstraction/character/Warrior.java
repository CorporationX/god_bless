package faang.school.godbless.Abstraction.character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public int attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
        return character.getHealth();
    }
}
