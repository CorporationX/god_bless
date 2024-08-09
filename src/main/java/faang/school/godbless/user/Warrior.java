package faang.school.godbless.user;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
        System.out.println(this);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(this.power);
        System.out.println("Warrior " + this.name + " attacks " + opponent.name + " for " + this.power + " damage.");
    }
}
