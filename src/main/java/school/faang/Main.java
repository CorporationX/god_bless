package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;

import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] args) {
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("Алияр", 15, "Ульянова", "Окей"));
//        users.add(new User("Артём", 20, "Ленина", "Петрович"));
//        users.add(new User("Мария", 15, "Киров", "Тест"));
//
//        Map<Integer, List<User>> groupedUsers = groupUsers(users);
//
//        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
//            System.out.println("Age: " + entry.getKey());
//            for (User user : entry.getValue()) {
//                System.out.println(" - " + user.getName());
//            }
//        }

        Archer asya = new Archer("Ася");
        Warrior wari = new Warrior("Вари");

        wari.attack(asya);
        System.out.println(asya.name + " здоровье: " + asya.health);

        asya.attack(wari);
        System.out.println(wari.name + " здоровье: " + wari.health);
    }
}


