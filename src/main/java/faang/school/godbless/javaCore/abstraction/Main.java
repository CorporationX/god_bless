package faang.school.godbless.javaCore.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");

        System.out.println(archer);
        System.out.println(warrior.attack(archer));

        System.out.println(warrior);
        System.out.println(archer.attack(warrior));
    }
}