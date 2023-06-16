package faang.school.godbless.third;

public class Warrior extends Character {
    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }
}
