package school;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
        this.agility = 5;
        this.intelligence = 3;
        this.strength = 10;
    }

    @Override
    public void attack(Character character) {
        character.helth = character.helth - this.strength;
    }

}
