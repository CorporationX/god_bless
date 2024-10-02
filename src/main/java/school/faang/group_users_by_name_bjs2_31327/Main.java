package school.faang.group_users_by_name_bjs2_31327;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", "25", "TechCorp", "123 Elm St"),
                new User("Bob", "30", "Finance Inc.", "456 Oak St"),
                new User("Charlie", "25", "Health Services", "789 Maple St"),
                new User("Diana", "40", "Education Co.", "101 Pine St"),
                new User("Eve", "30", "Legal Advisers", "202 Birch St")
        );

        System.out.println(User.groupUsers(userList).get("25"));
        System.out.println("------");
        System.out.println(User.groupUsers(userList).get("30"));
    }
}
