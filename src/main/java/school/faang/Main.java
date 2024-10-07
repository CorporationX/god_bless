package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Abzalkhan", "24", "IT", "60 Bob street"));
        userList.add(new User("Nural", "25", "Health care", "65 Bob street"));
        userList.add(new User("Aida", "25", "Student", "70 Bob street"));
        userList.add(new User("Olzhas", "24", "IT", "75 Bob street"));
        userList.add(new User("Ruslan", "25", "IT", "80 Bob street"));

        System.out.println(User.groupUsers(userList).get("25"));
    }
}
