package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name);
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
