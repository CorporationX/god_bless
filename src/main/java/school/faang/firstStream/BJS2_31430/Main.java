package school.faang.firstStream.BJS2_31430;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Mark", 22, "IT", "Berlin");
        User user2 = new User("Tim", 25, "Sales", "London");
        User user3 = new User("Lucas", 25, "HR", "Madrid");
        User user4 = new User("Guillermo", 22, "IT", "Roma");
        User user5 = new User("Dennis", 22, "Sales", "Hamburg");
        User user6 = new User("Mustafa", 22, "HR", "Istanbul");

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
