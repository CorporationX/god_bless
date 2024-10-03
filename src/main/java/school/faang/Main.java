package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User Alexander = new User("Alexander", 20, "SNG");
        User Timur = new User("Timur", 25, "Administration");
        User Denis = new User("Denis", 20, "RosNeft");
        User Kirill = new User("Kirill", 24, "SNG");
        User Artur = new User("Artur", 25, "Administration");
        User Artem = new User("Artem", 24, "SNG");
        List<User> userList = List.of(Alexander,Timur, Denis, Kirill, Artur, Artem);

        Map<Integer, List<User>> result = User.groupUsers(userList);
        System.out.println(result);

    }
}
