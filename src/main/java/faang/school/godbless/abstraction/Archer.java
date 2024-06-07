package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer (String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character opponent) {
        int newHealth = opponent.getHealth() - this.getAgility();
        opponent.setHealth(newHealth);
        System.out.println(this.getName() + " attacking " + opponent.getName());
        System.out.println("Remained health for " + opponent.getName() + " : " + opponent.getHealth());
    }
}
