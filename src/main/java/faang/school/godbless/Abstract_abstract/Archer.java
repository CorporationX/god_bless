package faang.school.godbless.Abstract_abstract;

public class Archer extends Characters {

    public Archer(String name) {
        super(name, 4, 3, 2);
    }

    @Override
    void attack(Characters characters) {
        characters.setHp(characters.getHp() - this.getAgility());
    }
}
