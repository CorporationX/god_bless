package faang.school.godbless.task3;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setForce(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character deffer) {
        attack(deffer, getForce());
    }
}
