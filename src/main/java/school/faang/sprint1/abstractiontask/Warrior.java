package school.faang.sprint1.abstractiontask;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= strength;
    }
}
