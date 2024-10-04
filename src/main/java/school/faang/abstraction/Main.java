package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Alex");
        Character archer = new Archer("Ivan");
        printCharacterStatistics(warrior, archer);

        warrior.attack(archer);
        archer.attack(warrior);
        printCharacterStatistics(warrior, archer);
    }

    private static void printCharacterStatistics(Character... characters) {
        for (Character character : characters) {
            System.out.printf(
                    "%s health: %d%n",
                    character.getClass().getSimpleName(),
                    character.getHealth()
            );
        }
    }
}
