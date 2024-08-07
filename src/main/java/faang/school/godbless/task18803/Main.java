package faang.school.godbless.task18803;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior", 22, 13, 66);
        Character archer = new Archer("Archer", 33, 6, 19);
        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(warrior);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
