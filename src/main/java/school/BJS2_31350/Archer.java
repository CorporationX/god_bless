package school.BJS2_31350;

public class Archer extends Character {

    public Archer(String name){
        super(name,3,10,5);
    }

    @Override
    public void attack(Character character) {
        character.setHelth(character.getHealth() - agility);
    }

}
