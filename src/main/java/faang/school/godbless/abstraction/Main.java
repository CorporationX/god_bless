package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Tom");
        Character archer = new Archer("Sam");

        System.out.println("Start:");
        System.out.println(warrior);
        System.out.println(archer);

        System.out.println("Warrior " + warrior.getName() + " attacks archer " + archer.getName());
        warrior.attack(archer);
        System.out.println("Archer " + archer.getName() + " attacks warrior " + warrior.getName());
        archer.attack(warrior);
        System.out.println("Warrior " + warrior.getName() + " attacks archer " + archer.getName());
        warrior.attack(archer);

        System.out.println("Finish:");
        System.out.println(warrior); //has health=90 (has been attacked once)
        System.out.println(archer); //has health=80 (has been attacked twice)
    }
}
