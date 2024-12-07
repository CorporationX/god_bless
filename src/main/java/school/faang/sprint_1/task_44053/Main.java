package school.faang.sprint_1.task_44053;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        User alex = new User(1, "Alex", 20, new HashSet<>(Set.of("Football", "Gaming")));
        User bob = new User(2, "Bob", 22, new HashSet<>(Set.of("Football", "Programming")));
        User tom = new User(3, "Tom", 20, new HashSet<>(Set.of("Tennis", "Reading")));
        users.add(alex);
        users.add(bob);
        users.add(tom);

        System.out.println(User.findHobbyLovers(users, new HashSet<>(Set.of("Tennis", "Gaming"))));
    }
}
