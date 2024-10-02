package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("John", 25, "Engineer", "New York"));
        users.add(new User("Jane", 30, "Doctor", "Los Angeles"));
        users.add(new User("Alice", 30, "Doctor", "Houston"));

        Map<Integer, List<User>> result = User.groupUsers(users);
        result.forEach((K,V) -> System.out.println("age: "+ K + " person: " + V));
    }
}
