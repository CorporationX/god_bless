package faang.school.godbless.BJS2_5213;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }
}
