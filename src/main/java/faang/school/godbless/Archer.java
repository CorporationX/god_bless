package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.force = 3;
        this.agility = 10;
        this.intellect = 5;

    }

    @Override
    void attack(Character character) {
        character.setHp(character.getHp() - this.getAgility());
    }


}
