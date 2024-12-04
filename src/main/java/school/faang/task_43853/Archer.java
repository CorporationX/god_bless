package school.faang.task_43853;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public double attack(Character character) {
        character.setHealth(character.getHealth() - agility);
        return agility;
    }
}
