package iplaytobranch;

public class Archer extends Character{

    public Archer(String name) {
        super(3,5,10,name);
    }

    @Override
    public void attack(Character character) {
        health = health - character.skil;
    }
}


