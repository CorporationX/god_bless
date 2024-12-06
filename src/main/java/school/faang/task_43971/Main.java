package school.faang.task_43971;

import java.util.List;

import static school.faang.task_43971.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(new User("John", 30, "Amazon", "Canada"),
                new User("Samanta", 15, "Google", "Florida"),
                new User("Silvester", 56, "VK", "Derevnya"),
                new User("Arnold", 44, "Tik-Tok", "Home"),
                new User("Laqvanda", 44, "Yandex", "Zelepupinsk"));

        System.out.println(groupUsers(userList));//NOSONAR

    }
}
