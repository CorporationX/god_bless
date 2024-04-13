package faang.school.godbless.Task_3;

public class Main {
    public static void main(String[] args) {

        Character warrior = new Warrior("John");
        Character archer = new Archer("Mike");

        warrior.attack(archer);
        System.out.println("----------------------");
        archer.attack(warrior);
    }
}
