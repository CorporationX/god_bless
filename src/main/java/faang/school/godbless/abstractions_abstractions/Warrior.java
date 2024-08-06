package faang.school.godbless.abstractions_abstractions;

public class Warrior extends Character{

    public Warrior(String name) {
        super(10, 5, 3);
        super.name = name;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.power;
    }
}
