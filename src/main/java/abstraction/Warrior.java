package abstraction;

public class Warrior extends Character {
    {
        this.power = 10;
        this.skill = 5;
        this.intellect = 3;
    }

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int skill, int intellect) {
        super(name);
        this.power = power;
        this.skill = skill;
        this.intellect = intellect;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.power;
    }
}
