package faang.school.godbless.bjs2_4226;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setAgility(5);
        this.setIntellect(3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }
}
