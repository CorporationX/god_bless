package school.faang.JavaBasic.BJS2_31304;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        printHealthStatus(warrior, archer);

        warrior.attack(archer);
        archer.attack(warrior);

        printHealthStatus(warrior, archer);
    }

    private static void printHealthStatus(Character firstCharacter, Character secondCharacter) {
        System.out.println("Здоровье " + firstCharacter.getName() + ": " + firstCharacter.getHealth());
        System.out.println("Здоровье " + secondCharacter.getName() + ": " + secondCharacter.getHealth());
    }
}
