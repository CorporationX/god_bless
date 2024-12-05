package school.faang.task_43992;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User userOne = new User("Megan", 29, "Paris", "1street");
        User userTwo = new User("Sarah", 29, "London", "2street");
        User userThree = new User("Willow", 30, "Moscow", "3street");
        User userFour = new User("Karmen", 30, "Tokyo", "4street");

        List<User> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);
        users.add(userFour);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        User.printUsers(groupedUsers);
    }
}
