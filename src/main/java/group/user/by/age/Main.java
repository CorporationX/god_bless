package group.user.by.age;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> listWithUsers = List.of(
                new User("Dan", 25, "Stefan cel Mare Street", "Chisinau MDA"),
                new User("John", 45, "Wall Street", "New York NY"),
                new User("Jane", 25, "Liberty Street", "Los Angeles CA"),
                new User("Mike", 45, "Umbrela Street", "London UK"));

        for (Map.Entry<Integer, List<User>> listWithUsersEntry : User.groupUsers(listWithUsers).entrySet()) {
            for (User user : listWithUsersEntry.getValue()) {
                System.out.printf("User with age %d is %s with working address %s based in %s %n",
                        user.getAge(),
                        user.getName(),
                        user.getAdress(),
                        user.getWorkPlace());
            }
        }
    }
}
