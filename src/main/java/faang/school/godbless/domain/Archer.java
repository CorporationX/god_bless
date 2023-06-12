package faang.school.godbless.domain;

public class Archer extends Character {

    private Integer power;
    private Integer agility;
    private Integer intellect;

    public Archer(String name, Integer power, Integer agility, Integer intellect) {
        super(name, power, agility, intellect);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.setPower(character.getPower() - character.getIntellect());
    }
}
