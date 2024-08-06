package faang.school.godbless.abstraction;

public class Archer extends Character{

    public Archer(String name){
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - agility);
    }
}
