package faang.school.godbless.abstraction_abstraction;

public class Archer extends Character {
    public Archer (String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
//        Is this the right way to do it? i guess setter like damage that modifies health would be better. Still doesnt feel right
        target.health = target.health - this.agility;
    }
}
