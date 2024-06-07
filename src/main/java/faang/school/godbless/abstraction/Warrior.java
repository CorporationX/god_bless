package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int newHealth = opponent.getHealth() - this.getPower();
        opponent.setHealth(newHealth);
        System.out.println(this.getName() + " attacking " + opponent.getName());
        System.out.println("Remained health for " + opponent.getName() + " : " + opponent.getHealth());
    }
}

