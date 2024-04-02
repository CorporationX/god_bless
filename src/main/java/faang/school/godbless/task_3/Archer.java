package faang.school.godbless.task_3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.dexterity;
    }
}
