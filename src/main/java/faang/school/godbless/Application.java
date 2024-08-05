package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        simulateFight(warrior, archer);
    }

    static void simulateFight(Character character1, Character character2) {
        while (character1.getHealth() > 0) {
            int archerHealth =  character1.getHealth();

            character2.attack(character1);

            System.out.println(character2.getName() + " attacked " + character1.getName());
            System.out.println(character1.getName() + " took health damage " + Math.abs(character1.getHealth() - archerHealth));
        }

        System.out.println("Game over");
        System.out.println(character1.getName() + " is dead");
        System.out.println(character2.getName() + " won!");
    }
}