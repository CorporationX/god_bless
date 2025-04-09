package school.faang.collectionuser;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities = Set.of("ФУБЛОЛ", "ВОЛЕЙБОЛ", ",БОРЬБА");

        Set<User> users = Set.of(
                new User(1, "Mikhaill", 32, Set.of("БОРЬБА", "ВОЛЕЙБОЛ", "ТЕНИС")),
                new User(2, "Alina", 28, Set.of("БАСКЕТБОЛ", "ВОЛЕЙБОЛ", "ТЕНИС")),
                new User(3, "Artem", 45, Set.of("ТЕНИС")));

        System.out.println(User.findHobbyLovers(users, activities));
    }
}