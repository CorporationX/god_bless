package derschrank.sprint01.task03.bjstwo_43815;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Voin");
        Character archer = new Archer("Luchnik");

        System.out.println("Begin: ");
        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("\nAfter first attack: ");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);

    }
}
