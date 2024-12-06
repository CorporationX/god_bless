package school.faang.task_43971;

import java.util.List;
import java.util.Map;

import static school.faang.task_43971.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(new User("John", 30, "Amazon", "Canada"),
                new User("Samanta", 15, "Google", "Florida"),
                new User("Silvester", 56, "VK", "Derevnya"),
                new User("Arnold", 44, "Tik-Tok", "Home"),
                new User("Laqvanda", 44, "Yandex", "Zelepupinsk"));

        Map<Integer, List<User>> returnedGroupedUsers = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> element : returnedGroupedUsers.entrySet()) {
            System.out.println(element);

        }
    }
}
