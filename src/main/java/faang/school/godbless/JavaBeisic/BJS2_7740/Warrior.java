package faang.school.godbless.JavaBeisic.BJS2_7740;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }
    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        opponent.setHealth(opponent.getHealth() - damage);
        System.out.println(this.name + " attacks " + opponent.getName() + " with strength, dealing " + damage + " damage.");
    }
}
