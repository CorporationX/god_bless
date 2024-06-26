package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7740;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }
    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        opponent.setHealth(opponent.getHealth() - damage);
        System.out.println(this.name + " attacks " + opponent.getName() + " with agility, dealing " + damage + " damage.");
    }
}
