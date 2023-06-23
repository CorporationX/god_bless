package faang.school.godbless.Sprint2.task3;

public class Archer extends Character {

    public Archer(String name) {
        super(name,3,10,5);
    }

    @Override
    public void attack(Character deffer) {
        double damage = getAgility();
        double hp = deffer.getHealth();
        if (damage >= hp) {
            deffer.setHealth(0);
            System.out.println("+Kill");
        } else {
            deffer.setHealth(hp - damage);
        }
    }
}
