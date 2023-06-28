package faang.school.godbless.Sprint2.task3_Sprint2;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,10,5,3);
    }

    @Override
    public void attack(Character deffer) {
        double damage = getForce();
        double hp = deffer.getHealth();
        if (damage >= hp) {
            deffer.setHealth(0);
            System.out.println("+Kill");
        } else {
            deffer.setHealth(hp - damage);
        }
    }
}
