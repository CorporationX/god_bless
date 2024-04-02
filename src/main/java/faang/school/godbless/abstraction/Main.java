package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer legolas = new Archer("Legolas");
        Warrior gimli = new Warrior("Gimli");

        System.out.println("Archer:");
        System.out.println(legolas + "\n");

        System.out.println("Warrior:");
        System.out.println(gimli + "\n");

        System.out.println("Both of them hit each other. After that:");

        legolas.attack(gimli);
        gimli.attack(legolas);

        System.out.println("Archer:");
        System.out.println(legolas + "\n");

        System.out.println("Warrior:");
        System.out.println(gimli + "\n");

    }
}
