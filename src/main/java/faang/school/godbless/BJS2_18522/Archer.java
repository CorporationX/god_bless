package faang.school.godbless.BJS2_18522;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int strength, int dexterity, int intelligence) {
        super(3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }
}
