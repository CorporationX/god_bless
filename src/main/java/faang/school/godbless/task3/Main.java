package faang.school.godbless.task3;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("War");
        Character archer = new Archer("Arch");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Archer: " + archer.getHealth());
        System.out.println("Warrior: " + warrior.getHealth());
    }
}
