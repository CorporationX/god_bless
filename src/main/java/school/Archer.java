package school;

public class Archer extends Character{

    public Archer(String name){
        super(name);
        this.agility = 10;
        this.intelligence = 5;
        this.strength = 3;
    }

    @Override
    public void attack(Character character) {
        character.helth = character.helth - this.agility;
    }

}
