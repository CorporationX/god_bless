package school.faang.bjs243816;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = getAgility();
        character.takeDamage(damage);
        System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage.");
    }
}