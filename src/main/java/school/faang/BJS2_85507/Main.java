package school.faang.BJS2_85507;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        //Test:
        Set<String> hobbies = new HashSet<>(Arrays.asList("Керлинг", "баскетбол", "хоккей"));
        List<String> hobbies2 = Arrays.asList("Вышивание", "хоккей", "футбол");
        User user1 = new User(1L, "Вася", 25, hobbies);
        User user2 = new User(2L, "Петя", 23, hobbies);
        User user3 = new User(3L, "Оля", 18, hobbies);
        User user4 = new User(4L, "Глаша", 31, hobbies);
        Set<User> users = new HashSet<>(Arrays.asList(user1, user2, user3, user4));
        HashMap<User, String> usersAndTheirHobbies = User.findHobbyLovers(users, hobbies2);
        System.out.println(List.of(usersAndTheirHobbies));
    }
}
