package school.faang.BJS2_31704;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Mark", 22, "Google", "London");
        User user2 = new User("Tim", 25, "Uber", "London");
        User user3 = new User("Lucas", 25, "Amazon", "New York");
        User user4 = new User("Guillermo", 22, "Google", "New York");
        User user5 = new User("Dennis", 22, "Uber", "Amsterdam");
        User user6 = new User("Mustafa", 22, "Amazon", "Amsterdam");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Map<Integer, List<User>> usersGroupByAge = User.groupUsers(users);

        //для удобства вывожу лишь имена, а так можно вывести и все поля.
        usersGroupByAge.forEach((age, usersGroup) -> {
            System.out.println("Users with age " + age + ":");
            usersGroup.forEach(user -> System.out.println(user.getName()));
            System.out.println();
        });
    }
}
