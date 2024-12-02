package school.faang.task_43807;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }
    @Override
    public void attack(Character other) {
        System.out.println(other + " attack Archer");
        super.health -= other.dexterity;
    }
}
