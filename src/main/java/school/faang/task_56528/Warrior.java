package school.faang.task_56528;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(power);
    }
}
