package faang.school.godbless.absractionabstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.agility);
    }
}
