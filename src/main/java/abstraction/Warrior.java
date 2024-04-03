package abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        System.out.println("Битва началась!");
        System.out.println("У " + character.getName() + ": "
                + character.getHealth() + " HP");

        System.out.println("\nУдар мечом!");
        character.setHealth(
                character.getHealth() - this.power
        );

        System.out.println("\nАтака закончена!");
        System.out.println("У " + character.getName() + ": "
                + character.getHealth() + " HP\n");
        System.out.println("========================\n");

    }
}
