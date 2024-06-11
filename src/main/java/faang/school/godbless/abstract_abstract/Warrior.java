package faang.school.godbless.abstract_abstract;

public class Warrior extends Character {

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character anotherCharacter) {
        anotherCharacter.health = anotherCharacter.health - this.power;
    }
}
