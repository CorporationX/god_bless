package school.faang.task_43902;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Hawkeye");

        System.out.println(warrior.name + " Health: " + warrior.getHealth());
        System.out.println(archer.name + " Health: " + archer.getHealth());

        System.out.println("\n" + warrior.name + " attacks: " + archer.name);
        warrior.attack(archer);
        System.out.println(archer.name + " health after attacks: " + archer.getHealth());

        System.out.println("\n" + archer.name + " attacks: " + warrior.name);
        archer.attack(warrior);
        System.out.println(warrior.name + " health after attacks: " + warrior.getHealth());
    }
}