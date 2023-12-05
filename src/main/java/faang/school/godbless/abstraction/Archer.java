package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.health = character.health - super.dexterity;
    }
}
