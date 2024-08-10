package abstraction;

public class Warrior extends Character{


    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setDexterity(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp()-this.getStrength());
    }
}
