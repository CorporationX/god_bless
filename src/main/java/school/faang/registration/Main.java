package school.faang.registration;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User alex;
        User ann;
        User artem;
        try {
            alex = new User("", 27, "Google", "London");
            ann = new User("Ann", 17, "Amazon", "Amsterdam");
            artem = new User("Artem", 29, "Yandex", "New York");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        List<User> userList = List.of(alex, ann, artem);

        Map<Integer, List<User>> userMap = User.groupUsers(userList);
        System.out.println(userMap);
    }
}
