package faang.school.godbless.Abstraction;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        int damage = this.getStrength();
        character.health -= damage;
        System.out.println("Warrior attacks " + character.getName() + " with damage: " + this.getStrength()
                + ", now " + character.getName() + " health is: " + character.getHealth());
    }
}
