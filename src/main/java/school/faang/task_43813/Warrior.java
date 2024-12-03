package school.faang.task_43813;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        health -= opponent.power;
        opponent.health -= power;
    }
}
