package faang.school.godbless.Abstraction.character;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public int attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
        return character.getHealth();
    }
}
