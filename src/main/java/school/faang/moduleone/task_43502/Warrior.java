package school.faang.moduleone.task_43502;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int agility, int intelligence) {
        this(name);
    }

    @Override
    public void attack(Character character) {
        character.heath -= this.power;
    }
}
