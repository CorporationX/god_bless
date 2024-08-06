package faang.school.godbless.BJS2_18482;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User elon = new User("Elon", 16, "Sber", "RF, Moscow");
        User alice = new User("Alice", 18, "Yandex", "RF, Piter");
        User jacob = new User("Jacob", 16, "Avito", "RF, Kazan");
        User william = new User("William", 18, "Google", "RF, Omsk");
        users.add(elon);
        users.add(alice);
        users.add(jacob);
        users.add(william);

        System.out.println(User.groupUsers(users));
    }
}
