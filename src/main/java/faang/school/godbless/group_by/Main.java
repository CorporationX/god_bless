package faang.school.godbless.group_by;

import faang.school.godbless.registration.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> listUsers = List.of(
                new User("Olya", 23, "Audi", "Germany"),
                new User("Vadim", 35, "BMW", "France"),
                new User("Anna", 40, "FIAT", "Italy"),
                new User("Boris", 35, "Audi", "Greece"),
                new User("Ignat", 57, "KIA", "Japan")
        );
        System.out.println(listUsers);
        System.out.println(User.groupUsers(listUsers));
    }
}