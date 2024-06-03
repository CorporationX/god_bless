package faang.school.godbless;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.force = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    void attack(Character character) {
        character.setHp(character.getHp() - this.getForce());
    }

}
