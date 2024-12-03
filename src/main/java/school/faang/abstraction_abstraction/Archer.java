package school.faang.abstraction_abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " (Archer) attacks " + opponent.getName());
        opponent.health -= dexterity;
        System.out.println(opponent.getName() + " now has " + opponent.getHealth() + " health.");
    }
}
