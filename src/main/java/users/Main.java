package users;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<User> users = new ArrayList<>();

        User.groupUsers(users);
    }
}
