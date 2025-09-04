package school.faang.abstraction_abstraction;

public class Archer extends Character {

    private static final int STRENGTH_VALUE = 3;
    private static final int AGILITY_VALUE = 10;
    private static final int INTELLIGENCE_VALUE = 5;

    public Archer(String name) {
        super(name, STRENGTH_VALUE, AGILITY_VALUE, INTELLIGENCE_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Лучник " + getName() + " атакует оппонента по имени " + opponent.getName() + ".");
        System.out.print("Здоровье оппонента: " + opponent.getHealth());
        opponent.takeDamage(getAgility());
        System.out.println(" -> " + opponent.getHealth() + "\n");
    }
}
