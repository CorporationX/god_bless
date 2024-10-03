package school.faang;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Alex");
        Character archer = new Archer("Ivan");
        printStatistics(warrior, archer);

        warrior.attack(archer);
        archer.attack(warrior);
        printStatistics(warrior, archer);
    }

    private static void printStatistics(Character... characters) {
        for (Character character : characters) {
            System.out.printf(
                    "%s health: %d%n",
                    character.getClass().getSimpleName(),
                    character.getHealth()
            );
        }
    }
}
