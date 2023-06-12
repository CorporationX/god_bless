package faang.school.godbless.domain;

public class Warrior extends Character {

    private Integer agility;
    private Integer intellect;

    public Warrior(String name, Integer power, Integer agility, Integer intellect) {
        super(name, power, agility, intellect);
        Integer power1 = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public void attack(Character character) {
        character.setPower(character.getAgility() - character.getAgility());
    }
}
