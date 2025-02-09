package school.faang.task56515.character;

public class Warrior extends school.faang.task56515.character.Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setIntelligence(3);
        this.setDexterity(5);
    }

    public Warrior(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name, strength, dexterity, intelligence);
        this.setStrength(10);
        this.setIntelligence(3);
        this.setDexterity(5);
    }

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        opponent.setHealth(Math.max(opponent.getHealth() - strength, 0));
    }
}
