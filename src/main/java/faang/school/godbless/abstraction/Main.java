package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Character char1 = new Warrior("Warrior");
        Character char2 = new Archer("Archer");
        Character attackedChar = new Warrior("Dummy");

        System.out.println(char1);
        System.out.println(char2);
        System.out.println(attackedChar);

        char1.attack(attackedChar);
        char2.attack(attackedChar);

        System.out.println(char1);
        System.out.println(char2);
        System.out.println(attackedChar);
    }
}
