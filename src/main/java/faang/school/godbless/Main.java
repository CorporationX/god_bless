package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User us1 = new User("Andrew", "Uber", "Amsterdam", 25);
        User us2 = new User("Stepan", "Yandex", "Moscow", 25);
        User us3 = new User("Vladislav", "NotWorker", "Moscow", 25);
        User us4 = new User("Alexandr", "Logist", "Moscow", 22);

        List<User> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);

        System.out.println(User.groupUsers(users));

    }
}
