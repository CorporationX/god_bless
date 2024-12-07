package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Sam");
        Character archer = new Archer("Tim");

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        warrior.attack(archer);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
