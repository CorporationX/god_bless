package school.faang.sprint1.bjs_43880;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thor");
        printStatistics(warrior);

        Character archer = new Archer("Howkeye");
        printStatistics(archer);

        warrior.attack(archer);
        printStatistics(archer);

        archer.attack(warrior);
        printStatistics(warrior);
    }

    private static void printStatistics(Character character) {
        System.out.println(character.toString());
    }
}
