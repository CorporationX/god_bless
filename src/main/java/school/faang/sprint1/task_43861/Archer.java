package school.faang.sprint1.task_43861;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.consumeDamage(agility);
    }
}
