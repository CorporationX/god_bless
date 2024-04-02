package faang.school.godbless.bjs2_4226;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setAgility(10);
        this.setIntellect(5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }
}
