package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = getStrength();
        character.setHealth(character.getHealth() - damage);
        System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage.");

    }
}