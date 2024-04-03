package abstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        System.out.println("\nБитва началась!");
        System.out.println("У " + character.getName() + ": "
                + character.getHealth() + " HP");

        System.out.println("\nВыстрел из лука!");

        character.setHealth(
                character.getHealth() - this.agility
        );

        System.out.println("\nАтака закончена!");
        System.out.println("У " + character.getName() + ": "
                + character.getHealth() + " HP\n");
        System.out.println("========================\n");
    }
}
