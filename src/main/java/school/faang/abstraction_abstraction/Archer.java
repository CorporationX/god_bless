package school.faang.abstraction_abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Лучник " + getName() + " атакует оппонента по имени " + opponent.getName() + ".");
        System.out.print("Здоровье оппонента: " + opponent.getHealth());
        opponent.takeDamage(getAgility());
        System.out.println(" -> " + opponent.getHealth() + "\n");
    }
}
