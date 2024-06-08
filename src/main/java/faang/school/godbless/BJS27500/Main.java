package faang.school.godbless.BJS27500;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("001", "Maksim", 33, Set.of("Reading", "Cinema", "Java", "Sport")));
        users.add(new User("002", "Gena", 24, Set.of("Cinema", "Java", "Gaming")));
        users.add(new User("003", "Nikita", 33, Set.of("Cinema", "Repair", "Gaming")));
        users.add(new User("004", "Denya", 33, Set.of("Cinema", "Repair", "Gaming")));
        users.add(new User("005", "Angelina", 30, Set.of("Cinema", "Family", "Gaming")));
        users.add(new User("006", "Demid", 34, Set.of("Cinema", "Business", "Family")));

        User.printFindFirstHobby(users, Set.of("Java", "Gaming"));
    }
}
