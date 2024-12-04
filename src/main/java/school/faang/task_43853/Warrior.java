package school.faang.task_43853;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public double attack(Character character) {
        character.setHealth(character.getHealth() - power);
        return power;
    }
}
