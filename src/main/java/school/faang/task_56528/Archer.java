package school.faang.task_56528;


public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setDexterity(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(getDexterity());
    }
}
