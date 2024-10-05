package school.faang.abstractions;

public class Test {

    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("Warrior attack");
        warrior.attack(archer);
        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("Archer attack");
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
