package faang.school.godbless.task3;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        setForce(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character deffer) {
        attack(deffer, getAgility());
    }

}
