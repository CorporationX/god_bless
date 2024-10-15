package school.faang.firstStream.BJS2_31704;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Mark", 22, "Google", "London"),
                new User("Tim", 25, "Uber", "London"),
                new User("Lucas", 25, "Amazon", "New York"),
                new User("Guillermo", 22, "Google", "New York"),
                new User("Dennis", 22, "Uber", "Amsterdam"),
                new User("Mustafa", 22, "Amazon", "Amsterdam"));

        Map<Integer, List<User>> usersGroupByAge = User.groupUsers(users);

        //для удобства вывожу лишь имена, а так можно вывести и все поля.
        usersGroupByAge.forEach((age, usersGroup) -> {
            System.out.println("Users with age " + age + ":");
            usersGroup.forEach(user -> System.out.println(user.getName()));
            System.out.println();
        });
    }
}
