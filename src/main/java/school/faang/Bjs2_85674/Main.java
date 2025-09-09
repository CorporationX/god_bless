package school.faang.Bjs2_85674;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 20, "Store", "Lenina 22");
        User user2 = new User("Gleb", 21, "Store", "Lenina 21");
        User user3 = new User("Petr", 20, "Store", "Lenina 20");
        User user4 = new User("Inna", 22, "Store", "Lenina 19");
        User user5 = new User("Olga", 21, "Store", "Lenina 18");
        User user6 = new User("Anna", 30, "Store", "Lenina 17");
        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        System.out.println(User.groupUsers(users));
    }
}
