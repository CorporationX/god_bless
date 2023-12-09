package faang.school.godbless._Grouping_users;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Jack", 35);
        User user = new User("Jason", 18);

        List<User> users = List.of(user, user1);
        System.out.println(User.groupUsers(users));
    }
}
