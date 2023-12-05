package faang.school.godbless;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.health = character.health - this.dexterity;
    }
}
