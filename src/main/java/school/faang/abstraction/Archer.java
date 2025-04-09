package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, HeroSettings.ARCHER_STRENGTH_DEFAULT,
                HeroSettings.ARCHER_AGILITY_DEFAULT,
                HeroSettings.ARCHER_INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
            opponent.processDeathHero();
        } else {
            System.out.println("Противник повержен, хвтит его колотить !!!");
        }
    }
}