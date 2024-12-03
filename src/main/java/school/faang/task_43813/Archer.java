package school.faang.task_43813;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        health -= opponent.dexterity;
        opponent.health -= dexterity;
    }
}
