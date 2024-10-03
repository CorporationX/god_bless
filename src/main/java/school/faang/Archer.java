package school.faang;

public class Archer extends Character {
    public Archer(String name, int strengh, int dexterity, int intelligence) {
        super(name, strengh, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - dexterity);
    }
}