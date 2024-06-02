package faang.school.godbless.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Herald");
        Character archer = new Archer("not Herald");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
