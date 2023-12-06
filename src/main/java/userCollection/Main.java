package userCollection;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] listActivity = new String[]{"act1", "act2", "act3"};
        List<User> listUser = List.of(
                new User(1, "Vadim", 35, new String[]{"act1", "act4"}),
                new User(1, "Anna", 24, new String[]{"act6", "act4"}),
                new User(1, "Kirill", 24, new String[]{"act3", "act10"})
        );
        System.out.println(Arrays.toString(listActivity));
        System.out.println(listUser);
        System.out.println(User.findHobbyLovers(listUser, listActivity));
    }
}