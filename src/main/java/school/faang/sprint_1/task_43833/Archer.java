package school.faang.sprint_1.task_43833;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int force, int agility, int intelligence) {
        super(3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = health - character.getAgility();
    }
}