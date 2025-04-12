package school.faang;

import school.faang.abstraction.Archer;
import school.faang.abstraction.Warrior;
import school.faang.collectusers.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        characterTests();    
        testUsersGroupedByAge();
        testCollectUsers();
    }
    

    public static void testUsersGroupedByAge() {
        List<school.faang.groupusersage.User> users = List.of(
                new school.faang.groupusersage.User("Alice", 30, "TechCorp", "123 Main St"),
                new school.faang.groupusersage.User("Bob", 25, "Startup Inc", "456 Oak Ave"),
                new school.faang.groupusersage.User("Charlie", 30, "Global Ltd", "789 Pine Ln"),
                new school.faang.groupusersage.User("David", 25, "New Firm", "111 Willow Dr")
        );

        Map<Integer, List<school.faang.groupusersage.User>> groupedUsers =
                school.faang.groupusersage.User.groupUsers(users);
        for (Map.Entry<Integer, List<school.faang.groupusersage.User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age " + entry.getKey() + ": " + entry.getValue());
        }
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
  
    public static void testCollectUsers() {
        User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("Reading", "Hiking", "Photography")));
        User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("Gaming", "Coding", "Reading")));
        User user3 = new User(3, "Charlie", 40, new HashSet<>(Arrays.asList("Painting", "Gardening", "Cooking")));
        User user4 = new User(4, "David", 28, new HashSet<>(Arrays.asList("Coding", "Running", "Music")));
        User user5 = new User(5, "Eve", 35, new HashSet<>(Arrays.asList("Traveling", "Photography", "Yoga")));
        User user6 = new User(6, "Frank", 22, new HashSet<>(Arrays.asList("Gaming")));
        User user7 = new User(7, "Grace", 45, new HashSet<>());

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        Set<String> hobbiesToFind1 = new HashSet<>(Arrays.asList("Reading", "Coding"));
        Set<String> hobbiesToFind2 = new HashSet<>(Arrays.asList("Photography", "Swimming"));
        Set<String> hobbiesToFind3 = new HashSet<>(Arrays.asList("Gaming"));
        Set<String> hobbiesToFind4 = new HashSet<>(Arrays.asList("NonExistentHobby"));

        System.out.println("\nTest Case 1: Finding users who like Reading or Coding");
        Map<String, String> lovers1 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind1);
        System.out.println("Hobby Lovers: " + lovers1);

        System.out.println("\nTest Case 2: Finding users who like Photography or Swimming");
        Map<String, String> lovers2 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind2);
        System.out.println("Hobby Lovers: " + lovers2);

        System.out.println("\nTest Case 3: Finding users who like Gaming");
        Map<String, String> lovers3 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind3);
        System.out.println("Hobby Lovers: " + lovers3);

        System.out.println("\nTest Case 4: Finding users who like a non-existent hobby");
        Map<String, String> lovers4 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind4);
        System.out.println("Hobby Lovers: " + lovers4);
    }
}
