package school.BJS2_31350;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,10,5,3);
    }

    @Override
    public void attack(Character character) {
        character.setHelth(character.getHealth() - strength);
    }

}
