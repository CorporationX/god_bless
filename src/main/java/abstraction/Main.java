package abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thanos");
        Character archer = new Archer("Hawkeye");

        System.out.println("Before the attack:");
        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("After the attack:");
        System.out.println(warrior);
        System.out.println(archer);
    }
}
