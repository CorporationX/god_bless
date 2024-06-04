package faang.school.godbless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static faang.school.godbless.Example.reverse;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Draco", 15, "Wizard", "Hogwarts"));
        users.add(new User("Snape", 35, "Wizard", "Diagon Alley"));


        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Возраст: " + age);
            userList.forEach(user -> System.out.println("  " + user.getUsername() + " " + user.getAge() + " " + user.getAddress()));
        });
    }
}