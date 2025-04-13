package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Users> users = List.of(
                new Users("Emy", 18, "somewhere", "somewhere"),
                new Users("Penny", 18, "somewhere", "somewhere"),
                new Users("Bernadette", 19, "somewhere", "somewhere"),
                new Users("Leslie Winkle", 25, "somewhere", "somewhere"));
        Map<Integer, List<Users>> usersGroupByAge = Users.groupUsers(users);
        System.out.println(usersGroupByAge);
    }
}
