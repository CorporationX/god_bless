package school.faang.collect_users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static school.faang.collect_users.User.findHobbyLovers;

public class Main {

    private static User createUser(int id, String name, int age, Set<String> hobbies) {
        return new User(id, name, age, new HashSet<>(hobbies));
    }

    private static Set<String> createTargetHobbies(List<String> listOfHobbies) {
        return new HashSet<>(listOfHobbies);
    }

    static User user_1 = createUser(1, "Vasya", 20, Set.of("Walk", "Run"));
    static User user_2 = createUser(2, "Petya", 21, Set.of("Swimming", "Run"));
    static User user_3 = createUser(3, "Sergey", 24, Set.of("Walk", "Swimming", "Run"));
    static User user_4 = createUser(4, "Hope", 19, Set.of("Walk", "Swimming", "Run", "Guns"));
    static User user_5 = createUser(5, "Nastya", 30, Set.of("Bow", "Guns"));
    static User user_6 = createUser(6, "Nikolay", 41, Set.of("Walk", "Painting"));

    static List<User> listOfUsers = new ArrayList<>(Arrays.asList(
            user_1, user_2, user_3, user_4, user_5, user_6
    ));

    static Set<String> targetHobbies1 = createTargetHobbies(List.of("Guns"));
    static Set<String> targetHobbies2 = createTargetHobbies(List.of("Guns", "Run"));
    static Set<String> targetHobbies3 = createTargetHobbies(List.of());
    static Set<String> targetHobbies4 = createTargetHobbies(List.of("Painting"));
    static Set<String> targetHobbies5 = createTargetHobbies(List.of("Walk", "Run", "Guns"));

    static List<Set<String>> listOfSetHobbies = List.of(
            targetHobbies1, targetHobbies2, targetHobbies3, targetHobbies4, targetHobbies5
    );

    public static void main(String[] args) {
        System.out.println();

        for (Set<String> setOfHobbies : listOfSetHobbies) {
            Map<User, String> result = findHobbyLovers(listOfUsers, setOfHobbies);
            System.out.println("=== Поиск хобби: " + setOfHobbies + " ===");

            if (result.isEmpty()) {
                System.out.println("Совпадений не найдено");
            } else {
                result.forEach((user, hobby) ->
                        System.out.println("\t[+] " + user.getName() + " -> '" + hobby + "'")
                );
            }

            System.out.println();
        }
    }
}
