package school.faang.Abstraction_bjs2_79182;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        System.out.println("Здоровье противника " + opponent.getName() + " " + opponent.getHealth());
    }
}
