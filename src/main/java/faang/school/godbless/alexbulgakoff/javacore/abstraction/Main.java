package faang.school.godbless.alexbulgakoff.javacore.abstraction;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        System.out.println("Имя: " + archer.getName() +
                "\nСила: " + archer.getPower() +
                "\nЛовкость: " + archer.getDexterity() +
                "\nИнтеллект: " + archer.getIntelligence() +
                "\nЗдоровье: " + archer.getHealth());

        System.out.println();

        System.out.println("Имя: " + warrior.getName() +
                "\nСила: " + warrior.getPower() +
                "\nЛовкость: " + warrior.getDexterity() +
                "\nИнтеллект: " + warrior.getIntelligence() +
                "\nЗдоровье: " + warrior.getHealth());

        System.out.println();

        archer.attack(warrior);
        System.out.println("Archer attacks Warrior");
        System.out.println("Warrior health after attack: " + warrior.getHealth());
        System.out.println();
        warrior.attack(archer);
        System.out.println("Warrior attacks Archer");
        System.out.println("Archer health after attack: " + archer.getHealth());
    }
}
