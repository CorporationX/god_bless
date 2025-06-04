package school.faang;

import school.faang.groupingTask.User;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(
                new User("Frodo Begins", "Shire", "traveler", 50),
                new User("Bilbo Begins", "Shire", "traveler", 111),
                new User("Mister Reviewer", "Russia", "philanthropist", 25),
                new User("Anton Sidorov", "Hogwarts", "student", 25),
                new User("Egor Ivanov", "Narnia ", "merchant", 25));

        Map<Integer, List<User>> usersMap = User.groupUsers(usersList);

        for (Map.Entry<Integer, List<User>> entry : usersMap.entrySet()) {
            System.out.println("age of the group = " + entry.getKey());
            System.out.println(entry.getValue() + "\n");
        }
    }
}
