package school.faang.bjs2_31543_user_registration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", "25", "Google", "Amsterdam"),
                new User("Bob", "30", "Google", "New York"),
                new User("Charlie", "25", "Amazon", "Amsterdam"),
                new User("Diana", "30", "Amazon", "London")

//                If uncomment any row below will be throw IllegalArgumentException()

//                new User("", "40", "Uber", "New York")
//                new User("Eve", "12", "Uber", "New York")
//                new User("Eve", "40", "Horns and Hooves", "New York")
//                new User("Eve", "40", "Uber", "Paris")
        );

        System.out.println(User.groupUsers(userList).get("30"));
        System.out.println("------");
        System.out.println(User.groupUsers(userList).get("25"));

    }


}
