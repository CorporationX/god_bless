package school.faang.bjs2_85531;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public int getHeroAttackDamage() {
        return getAgility();
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.health = opponent.getHealth() - opponent.getHeroAttackDamage();
            if (opponent.getHealth() <= 0) {
                opponent.health = 0;
                System.out.println(opponent.getName() + " повержен");
                return;
            }
            System.out.println(opponent.getName() + " " + opponent.getHealth() + " ХП");
        }
    }
}
