package faang.school.godbless.task_3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setDexterity(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getDexterity());
    }
}
