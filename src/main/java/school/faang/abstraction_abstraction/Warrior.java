package school.faang.abstraction_abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Воин " + getName() + " атакует оппонента по имени " + opponent.getName() + ".");
        System.out.print("Здоровье оппонента: " + opponent.getHealth());
        opponent.takeDamage(getStrength());
        System.out.println(" -> " + opponent.getHealth() + "\n");
    }
}
