package school.faang.sprint_1.task_43849;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        dexterity = 10;
        intelligence = 5;
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= dexterity;
    }
}
