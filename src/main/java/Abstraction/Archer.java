package Abstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(
                name,
                strength = 3,
                dexterity = 10,
                intelligence = 5
        );
    }

    @Override
    public int attack(Character character) {
        int archerAttack = dexterity;
        return character.health - archerAttack;
    }
}