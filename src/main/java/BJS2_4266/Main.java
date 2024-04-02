package BJS2_4266;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> user = new ArrayList<>();
        user.add(new User("Ilya", 20, "Support", "Groove Street"));
        user.add(new User("Oleg", 23, "Cook", "Mira Street"));
        user.add(new User("Masha", 19, "Doctor", "Pushkina Street"));
        user.add(new User("Olga", 25, "Lawyer", "Stalina Street"));
        user.add(new User("Gloria", 20, "Policeman", "Lenina Street"));

        System.out.println(User.groupUsers(user));
    }
}
