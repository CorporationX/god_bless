package school.faang.task_56528;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setDexterity(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(getPower());
    }
}
