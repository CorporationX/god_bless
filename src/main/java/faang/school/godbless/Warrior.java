package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(int power, int intellect, int sleight) {
        super(10, 3, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
    }
}