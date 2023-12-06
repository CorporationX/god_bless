package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User boris = new User("Boris", 36, "Megafon", "Moskow");
        User mikhail = new User("Mihail", 25, "Google", "New York");
        User oleg = new User("Oleg", 36, "Amazon", "London");
        User elena = new User("Elena", 47, "Uber", "Amsterdam");
        User mila = new User("Mila", 25, "MTS", "Krasnodar");
        User sergey = new User("Sergey", 32, "Google", "Paris");
        users.add(boris);
        users.add(mikhail);
        users.add(oleg);
        users.add(elena);
        users.add(mila);
        users.add(sergey);

        User.groupUsers(users);

    }
}