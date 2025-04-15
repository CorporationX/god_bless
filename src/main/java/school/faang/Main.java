package school.faang;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(
                User.builder().name("Max").age(33).placeOfWork("Google").address("London").build(),
                User.builder().name("Anna").age(31).placeOfWork("Amazon").address("San Francisco").build(),
                User.builder().name("John").age(29).placeOfWork("Meta").address("Chicago").build(),
                User.builder().name("Yulia").age(22).placeOfWork("Apple").address("Berlin").build(),
                User.builder().name("Lev").age(36).placeOfWork("NVIDIA").address("New York").build()
        );

        Map<Integer, List<User>> groupedByAge = User.groupUsers(usersList);

        for (Map.Entry<Integer, List<User>> entry : groupedByAge.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}