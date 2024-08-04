package faang.school.godbless.abstraction;

public class Warrior extends Character{

    public Warrior(String name){
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - strength);
    }
}
