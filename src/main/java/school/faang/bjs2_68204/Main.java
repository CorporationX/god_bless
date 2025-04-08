package school.faang.bjs2_68204;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User userArtur = new User("Artur", 37, "Google", "New York");
        User userJoseph = new User("Joseph", 23, "Facebook", "Los Angeles");
        User userJane = new User("Jane", 23, "Twitter", "New York");
        User userJohn = new User("John", 23, "LinkedIn", "New York");
        List<User> users = List.of(userArtur, userJoseph, userJane, userJohn);
        Map<Integer, List<User>> usersAge = User.groupUsers(users);
        for (var entry : usersAge.entrySet()) {
            log.info("Age: {} - Users: {}", entry.getKey(), entry.getValue());
        }
    }
}