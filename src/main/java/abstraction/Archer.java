package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    public void attack(Character character) {
        character.health -= this.agility;
        System.out.println("Персонаж " + getName() + " нанес урон " + character.getName() + " в размере " + getAgility()
                + "\n" + character.getName() + " health: " + character.getHealth() + "\n");
    }
}
