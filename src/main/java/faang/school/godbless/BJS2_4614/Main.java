package faang.school.godbless.BJS2_4614;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList();
        users.add(new User("Serge", 26, "Java Developer", "Phuket island"));
        users.add(new User("Bato", 36, "Product Manager", "Ulan-Ude"));
        users.add(new User("Anna", 18, "Junior Developer", "Moscow"));
        users.add(new User("Max", 36, "CEO", "Adelaide"));

        System.out.println(User.groupUsers(users));
    }
}
