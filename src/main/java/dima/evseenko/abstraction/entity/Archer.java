package dima.evseenko.abstraction.entity;

public class Archer extends Character{
    public Archer(String name){
        super(name, 3, 10, 5);
    }

    @Override
    public Character attack(Character character) {
        System.out.printf("Archer %s attacked %s%n", this.getName(), character.getName());

        character.damage(getIntelligence());
        return character;
    }
}
