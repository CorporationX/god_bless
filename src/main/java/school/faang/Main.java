package school.faang;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User newUser1 = new User("John", 25,"Google", "123 Main St");
        User newUser2 = new User("Jane", 30,"Amazon", "456 Elm St");
        User newUser3 = new User("Bob", 35,"Microsoft", "789 Oak St");
        User newUser4 = new User("John2", 25,"Google", "123 Main St");
        User newUser5 = new User("Jane2", 30,"Amazon", "456 Elm St");
        User newUser6 = new User("Bob2", 35,"Microsoft", "789 Oak St");
        List<User> users = List.of(newUser1, newUser2, newUser3,newUser4, newUser5, newUser6);
        Map<Integer, List<User>> usersByAge = User.groupUsers(users);
        System.out.println(usersByAge);
    }
}
