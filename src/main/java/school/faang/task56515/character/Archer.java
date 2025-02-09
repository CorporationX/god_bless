package school.faang.task56515.character;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setIntelligence(5);
        this.setDexterity(10);
    }

    public Archer(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name, strength, dexterity, intelligence);
        this.setStrength(3);
        this.setIntelligence(5);
        this.setDexterity(10);
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        opponent.setHealth(Math.max(opponent.getHealth() - dexterity, 0));
    }
}
