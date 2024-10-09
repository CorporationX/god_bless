package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(20);
        this.setDexterity(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }
}
