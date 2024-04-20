package faang.school.godbless;

import faang.school.godbless.groupingUsersByAge.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mark", 25, "", ""));
        users.add(new User("Soslan", 30, "", ""));
        users.add(new User("Alex", 25, "", ""));
        users.add(new User("Piter", 30, "", ""));
        users.add(new User("Anton", 25, "", ""));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("age " + age);
            userList.forEach(user -> System.out.println("name: " + user.getName() + ", placeOfWork: " + user.getPlaceOfWork() + ", Address: " + user.getAddress()));
            System.out.println();
        });
    }
}
