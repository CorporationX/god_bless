package faang.school.godbless.BJS2_5213;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}
