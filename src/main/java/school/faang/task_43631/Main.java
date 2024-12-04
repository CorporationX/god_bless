package school.faang.task_43631;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static school.faang.task_43631.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("John", 30, "Amazon", "Canada");
        User secondUser = new User("Samanta", 15, "Google", "Florida");
        User thirdUser = new User("Arnold", 44, "Tik-Tok", "Home");
        User fourthUser = new User("Silvester", 56, "VK", "Derevnya");
        User fivesUser = new User("Laqvanda", 44, "Yandex", "Zelepupinsk");

        List<User> userList = new ArrayList<>();
        Collections.addAll(userList, firstUser, secondUser, thirdUser, fourthUser, fivesUser);

        System.out.println(groupUsers(userList));

    }
}
