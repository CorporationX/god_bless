package faang.school.godbless.bjs2_7777;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");

        System.out.println(warrior);
        System.out.println(archer);

        for (int i = 0; i < 5; i++) {
            warrior.attack(archer);
        }

        for (int i = 0; i < 7; i++) {
            archer.attack(warrior);
        }

        System.out.println(warrior);
        System.out.println(archer);
    }
}
