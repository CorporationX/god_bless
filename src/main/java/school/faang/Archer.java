package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setDexterity(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }
}
