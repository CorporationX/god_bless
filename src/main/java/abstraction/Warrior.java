package abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    public void attack(Character character) {
        character.health -= this.strength;
        System.out.println("Персонаж " + getName() + " нанес урон " + character.getName() + " в размере " + getStrength()
                + "\n" + character.getName() + " health: " + character.getHealth() + "\n");
    }
}
