package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntellect(5);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 1) {
            System.out.println("Archer attacking!!!!!!!!");
            character.setHealth(character.getHealth() - getAgility());
            System.out.println(character.getName() + " has " + character.getHealth() + " hp.");
        } else {
            System.out.println(character.getName() + " is death...");
        }
    }
}
