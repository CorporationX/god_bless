package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name);
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}
