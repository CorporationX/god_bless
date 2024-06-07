package faang.school.godbless.Abstract_abstract;

public class Warrior extends Characters {
    public Warrior(String name) {
        super(name, 5, 4, 2);
    }

    @Override
    void attack(Characters character) {
        character.setHp(character.getHp() - this.getForce());
    }
}
