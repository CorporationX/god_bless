package faang.school.godbless.Abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        int damage = this.getStrength();
        character.health -= damage;
        System.out.println("Archer attacks " + character.getName() + " with damage: " + this.getStrength()
                + ", now " + character.getName() + " health is: " + character.getHealth());
    }


}
