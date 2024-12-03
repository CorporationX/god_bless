package school.faang.sprint_1.task_43914;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", 20, "Google", "Moscow");
        User user2 = new User("Bob", 21, "Google", "Moscow");
        User user3 = new User("Marta", 22, "Google", "Moscow");
        User user4 = new User("Lex", 21, "Google", "Moscow");
        User user5 = new User("Tom", 20, "Google", "Moscow");
        User user6 = new User("Jerry", 22, "Google", "Moscow");
        User user7 = new User("Sam", 23, "Google", "Moscow");

        List<User> usersList = List.of(user1, user2, user3, user4, user5, user6, user7);

        System.out.println(User.groupUsers(usersList));

    }
}
