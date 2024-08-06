package faang.school.godbless.abstractions_abstractions;

public class Archer extends Character{
    public Archer(String name) {
        super(3, 10, 5);
        super.name = name;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.dexterity;
    }
}
