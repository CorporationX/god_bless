package bjs256438;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(User.builder().name("Vasiliy").age(31).workPlace("IT").address("Moscow").build());
        users.add(User.builder().name("Fyodor").age(31).workPlace("IT").address("Moscow").build());
        users.add(User.builder().name("Ivan").age(23).workPlace("Transport").address("Moscow").build());
        users.add(User.builder().name("Alexander").age(55).workPlace("Production").address("Spb").build());
        users.add(User.builder().name("Nikolay").age(31).workPlace("Medicine").address("Spb").build());
        users.add(User.builder().name("Symon").age(23).workPlace("HR").address("Volgograd").build());
        users.add(User.builder().name("Dmitriy").age(23).workPlace("Legal services").address("Tver").build());
        users.add(User.builder().name("Alexey").age(55).workPlace("Cleaning").address("Novosibirsk").build());
        users.add(User.builder().name("Grigoriy").age(19).workPlace("Hotel services").address("Kaliningrad")
                .build());
        users.add(User.builder().name("Eduard").age(66).workPlace("Development").address("Voronezh").build());
        users.add(User.builder().name("Uriy").age(25).workPlace("Tourism").address("Smolensk").build());

        User.groupUsers(users).forEach((age, ageGroup) -> System.out.println("Age: " + age
                + " Age group: " + ageGroup));
    }
}
