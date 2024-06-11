package faang.school.godbless.abstract_abstract;

public class Archer extends Character {

    public Archer(String name, int power, int agility, int intellect) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character anotherCharacter) {
        anotherCharacter.health = anotherCharacter.health - this.agility;
    }
}
