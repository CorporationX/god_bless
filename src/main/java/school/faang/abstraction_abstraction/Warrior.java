package school.faang.abstraction_abstraction;

public class Warrior extends Character {

    private static final int STRENGTH_VALUE = 10;
    private static final int AGILITY_VALUE = 5;
    private static final int INTELLIGENCE_VALUE = 3;

    public Warrior(String name) {
        super(name, STRENGTH_VALUE, AGILITY_VALUE, INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Воин " + getName() + " атакует оппонента по имени " + opponent.getName() + ".");
        System.out.print("Здоровье оппонента: " + opponent.getHealth());
        opponent.takeDamage(getStrength());
        System.out.println(" -> " + opponent.getHealth() + "\n");
    }
}
