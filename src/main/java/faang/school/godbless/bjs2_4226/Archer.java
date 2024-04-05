package faang.school.godbless.bjs2_4226;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, 3, 10, 5);
    }
}
