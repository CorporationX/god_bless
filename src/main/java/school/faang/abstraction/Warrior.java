package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, HeroSettings.WARRIOR_STRENGTH_DEFAULT,
                HeroSettings.WARRIOR_AGILITY_DEFAULT,
                HeroSettings.WARRIOR_INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
            opponent.processDeathHero();
        } else {
            System.out.println("Проивник повержен хватит его колоить !!!");
        }
    }
}