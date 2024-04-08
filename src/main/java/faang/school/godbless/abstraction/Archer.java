package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        super.power = 3;
        super.agility = 10;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        int damage = this.agility;
        character.setHealth(character.getHealth() - damage);
        System.out.println(super.name + " attacks " + character.getName() + " and damaged health: " + damage);
    }
}
