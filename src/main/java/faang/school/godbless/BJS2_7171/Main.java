package faang.school.godbless.BJS2_7171;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<String> activity = Set.of("running", "shooting", "swimming");
        Set<String> user_1_activity = Set.of("running", "shooting", "swimming");
        Set<String> user_2_activity = Set.of("swimming", "flying", "shooting", "snowboarding");
        Set<String> user_3_activity = Set.of("snowboarding", "flying", "eating");
        Set<String> user_4_activity = Set.of("swimming", "shooting", "eating", "running");
        Set<String> user_5_activity = Set.of("flying", "snowboarding");

        User user_1 = new User(1, "Vasya", 21, user_1_activity);
        User user_2 = new User(2, "Anya", 22, user_2_activity);
        User user_3 = new User(3, "Sveta", 23, user_3_activity);
        User user_4 = new User(4, "Kolya", 24, user_4_activity);
        User user_5 = new User(5, "Petya", 25, user_5_activity);

        Set<User> users = new HashSet<>();
        users.add(user_1);
        users.add(user_2);
        users.add(user_3);
        users.add(user_4);
        users.add(user_5);

        Map<User, String> result = findHobbyLovers(users, activity);
        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> activity) {
        if (users != null && activity != null) {
            return users.stream()
                    .filter(user -> !user.getActivity().stream().filter(activity::contains).collect(Collectors.toSet()).isEmpty())
                    .collect(Collectors.toMap(user -> user, user -> user.getActivity().stream().filter(activity::contains).findFirst().get()));
        } else return Map.of();
    }
}
