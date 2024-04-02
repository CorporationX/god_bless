package faang.school.godbless.task_3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.strength;
    }
}
