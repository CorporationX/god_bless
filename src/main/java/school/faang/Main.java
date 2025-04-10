package school.faang;

import school.faang.abstraction.Archer;
import school.faang.abstraction.Warrior;
import school.faang.groupusersage.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        characterTests();    
        testUsersGroupedByAge();
    }

    public static void testUsersGroupedByAge() {
        List<User> users = List.of(
                new User("Alice", 30, "TechCorp", "123 Main St"),
                new User("Bob", 25, "Startup Inc", "456 Oak Ave"),
                new User("Charlie", 30, "Global Ltd", "789 Pine Ln"),
                new User("David", 25, "New Firm", "111 Willow Dr")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ": " + entry.getValue());
    }

    public static void characterTests() {
        Warrior conan = new Warrior("Conan");
        Archer legolas = new Archer("Legolas");
        Warrior boromir = new Warrior("Boromir");

        System.out.println("--- Character Creation ---");
        System.out.println(conan.toString());
        System.out.println(legolas.toString());

        System.out.println("\n--- Basic Attacks ---");
        System.out.println(boromir.toString());
        boromir.attack(legolas);
        System.out.println(legolas.toString());

        System.out.println("\n--- Attack on a 'Dead' Character ---");
        legolas.setHealth(0);
        System.out.println(boromir.toString());
        boromir.attack(legolas);
        System.out.println(legolas.toString());

        System.out.println("\n--- Multiple Attacks ---");
        Warrior strongGuy = new Warrior("StrongGuy");
        Archer nimbleShot = new Archer("NimbleShot");
        System.out.println(nimbleShot.getName() + " Health: " + nimbleShot.getHealth());
        for (int i = 0; i < 11; i++) {
            strongGuy.attack(nimbleShot);
            System.out.println(strongGuy.toString());
        }

        System.out.println("\n--- Initial Health Check ---");
        Warrior anotherWarrior = new Warrior("Tank");
        Archer anotherArcher = new Archer("SharpEye");
        System.out.println(anotherWarrior.getName() + " initial Health: " + anotherWarrior.getHealth());
        System.out.println(anotherArcher.getName() + " initial Health: " + anotherArcher.getHealth());

        System.out.println("\n--- Initial Stats Check ---");
        System.out.println(anotherWarrior.toString());
        System.out.println(anotherArcher.toString());
    }
}
