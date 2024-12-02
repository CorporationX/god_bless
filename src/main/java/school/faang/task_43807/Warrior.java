package school.faang.task_43807;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character other) {
        System.out.println(other + " attack Warrior");
        super.health -= other.power;
    }
}
