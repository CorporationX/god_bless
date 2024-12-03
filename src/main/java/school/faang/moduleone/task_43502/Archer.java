package school.faang.moduleone.task_43502;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int agility, int intelligence) {
        this(name);
    }

    @Override
    public void attack(Character character) {
        character.heath -= this.agility;
    }
}
