package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.User.groupUsers;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("KOLYA", 34, "FBI", "London"));
        usersList.add(new User("PAVEL", 55, "KGB", "MOSCOW"));
        usersList.add(new User("SERGEY", 43, "MI-6", "London"));
        usersList.add(new User("IGOR", 55, "FBI", "London"));
        usersList.add(new User("JONNY", 31, "FBI", "PARIS"));
        usersList.add(new User("QWERTY", 43, "FBI", "London"));
        usersList.add(new User("LOBBY", 31, "FSB", "London"));
        usersList.add(new User("SLAVA", 34, "FBI", "London"));
        usersList.add(new User("VANYA", 34, "FBI", "London"));

        Map<Integer, List<User>> groupUsers = groupUsers(usersList);

        System.out.println("Возраст и пользователи:");
        groupUsers.forEach((age, users) -> {
            log.info("Возраст: {}", age);
            users.forEach(user -> System.out.println(" - " + user.name()));
        });
    }
}