package school.faang.task_43875;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        User user1 = new User("Anton", 26, "Uber", "Sovetskaya14");
        User user2 = new User("Sasha", 19, "Google", "Sovetskaya15");
        User user3 = new User("Nikita", 20, "Uber", "Sovetskaya251");
        User user4 = new User("Anna", 19, "Netflix", "Sovetskaya4");
        User user5 = new User("Kristina", 26, "Amazon", "Sovetskaya198");
        User user6 = new User("Maksim", 26, "Uber", "Sovetskaya567");

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
        usersList.add(user6);

        Map<Integer, List<User>> returnedGroupedUsers = User.groupUsers(usersList);

        for (Map.Entry<Integer, List<User>> currentElement : returnedGroupedUsers.entrySet()) {
            System.out.println(currentElement);
        }
    }
}

