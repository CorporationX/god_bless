package school.faang.bjs2_68215;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User userArtur = new User("Artur", 37, "Google", "New York");
        User userJoseph = new User("Joseph", 23, "Uber", "Amsterdam");
        User userJane = new User("Jane", 23, "Amazon", "London");
        User userJohn = new User("John", 25, "Uber", "New York");

        ArrayList<User> users = new ArrayList<>(List.of(userArtur, userJoseph, userJane, userJohn));
        for (User user : users) {
            log.info(user.toString());
        }
    }
}
