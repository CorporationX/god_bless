package school.faang.task_56528;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(dexterity);
    }
}
