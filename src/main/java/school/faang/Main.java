package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        try {
            users.add(new User("John", 25, "Google", "London"));
            users.add(new User("Jane", 30, "Uber", "New York"));
            users.add(new User("Jill", 17, "Amazon", "UK"));
            users.add(new User("Phillipp", 18, "MailRU", "London"));
            users.add(new User(null, 25, "Google", "London"));

            Map<Integer, List<User>> map = User.groupUsers(users);
            map.forEach((k, v) -> System.out.println("age: " + k + " person: " + v));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
