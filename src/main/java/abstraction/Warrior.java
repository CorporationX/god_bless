package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntellect(3);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 1) {
            System.out.println("Warrior attacking!!!!!!!!");
            character.setHealth(character.getHealth() - getStrength());
            System.out.println(character.getName() + " has " + character.getHealth() + " hp.");
        } else {
            System.out.println(character.getName() + " is death...");
        }
    }
}
