package school.faang.Abstraction_bjs2_79182;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        System.out.println("Здоровье противника " + opponent.getName() + " " + opponent.getHealth());
    }
}
