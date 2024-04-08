package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.power = 10;
        super.agility = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.setHealth(character.getHealth() - damage);
        System.out.println(this.name + " attacks " + character.getName() + " and damaged health: " + damage);
    }
}
