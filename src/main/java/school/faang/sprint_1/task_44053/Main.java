package school.faang.sprint_1.task_44053;

import java.util.*;

public class Main {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        User alex = new User(1, "Alex", 20, new HashSet<>(Set.of("Football", "Gaming")));
        User bob = new User(2, "Bob", 22, new HashSet<>(Set.of("Football", "Programming")));
        User tom = new User(3, "Tom", 20, new HashSet<>(Set.of("Tennis", "Reading")));
        users.add(alex);
        users.add(bob);
        users.add(tom);

        System.out.println(findHobbyLovers(users, new HashSet<>(Set.of("Tennis", "Gaming"))));

    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> userHobby = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    userHobby.put(user, hobby);
                }
            }
        }
        return userHobby;
    }
}
