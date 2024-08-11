package faang.school.godbless.task18803;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer, warrior);
        System.out.println(warrior);
        System.out.println(archer);

        archer.attack(warrior, archer);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
