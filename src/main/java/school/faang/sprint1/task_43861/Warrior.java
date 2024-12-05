package school.faang.sprint1.task_43861;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.consumeDamage(strength);
    }
}
