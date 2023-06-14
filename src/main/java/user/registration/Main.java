package user.registration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Sergey", 19, "Google", "London");
        User user2 = new User("Viktor", 19, "Uber", "Amsterdam");
        User user3 = new User("Andrew", 20, "Google", "London");
        User user4 = new User("Bika", 24, "Uber", "Amsterdam");
        User user5 = new User("Alex", 13, "Amazon", "New York");
        List<User> userList = List.of(user1, user2, user3, user4, user5);
        System.out.println(User.groupUsers(userList));
    }
}
