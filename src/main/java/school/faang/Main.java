package school.faang;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        final List<User> userList = List.of(
                new User("Person1", 20, "Company1", "Address1"),
                new User("Person2", 22, "Company2", "Address2"),
                new User("Person3", 22, "Company3", "Address3"),
                new User("Person4", 23, "Company4", "Address4"),
                new User("Person5", 24, "Company5", "Address5")

                );


        final Map<Integer, List<User>> result = User.groupUsers(userList);
        System.out.println(result);
    }
}
