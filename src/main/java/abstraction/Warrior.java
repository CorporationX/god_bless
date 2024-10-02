package abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

//    public Warrior(String name, int strength, int agility, int intelligence) {
//        super(name, strength, agility, intelligence);
//    }


    public void attack(Character character) {
        character.health -= this.strength;
        System.out.println("Персонаж " + getName() + " нанес урон " + character.getName() + " в размере " + getAgility()
                + "\n" + character.getName()+ " health: " + character.getHealth() + "\n");
    }
}
