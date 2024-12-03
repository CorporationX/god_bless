package school.faang.sprint_1.task_43833;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(int force, int agility, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = health - character.getForce();
    }
}