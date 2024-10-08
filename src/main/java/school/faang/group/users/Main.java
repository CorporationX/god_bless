package school.faang.group.users;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Sarah Thompson", "Creative Solutions Inc.", "123 Maple Street", 28),
            new User("David Johnson", "Tech Innovations LLC", "456 Oak Avenue", 35),
            new User("Emily Rodriguez",  "Global Enterprises", "789 Pine Road", 28),
            new User("Michael Lee", "Financial Insights Group", "321 Birch Lane", 35),
            new User("Jessica Kim", "Graphic Designer at Artistry Hub", "654 Cedar Drive", 28)
        );

        System.out.println(User.groupUsers(users));
    }
}
