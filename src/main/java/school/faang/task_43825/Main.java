package school.faang.task_43825;

public class Main {

    public static void main(String[] args) {
        Archer archer = new Archer("Archer1");
        Warrior warrior = new Warrior("Warrior1");

        printCharacter(archer);
        printCharacter(warrior);

        System.out.println();

        archer.attack(warrior);
        printCharacter(archer);
        printCharacter(warrior);

        System.out.println();

        warrior.attack(archer);
        printCharacter(archer);
        printCharacter(warrior);
    }

    private static void printCharacter(Character character) {
        System.out.println(character);
    }

}
