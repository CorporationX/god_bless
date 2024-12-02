package school.faang.task43920.model;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        this.health -= character.strength;
    }
}
