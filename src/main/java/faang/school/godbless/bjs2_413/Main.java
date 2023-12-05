package faang.school.godbless.bjs2_413;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = User.builder()
                .name("Anton")
                .age(23)
                .build();
        User user2 = User.builder()
                .name("Andrei")
                .age(13)
                .build();
        User user3 = User.builder()
                .name("Vova")
                .age(33)
                .build();
        User user4 = User.builder()
                .name("Roman")
                .age(23)
                .build();


        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println(User.groupUsers(users));
    }
}
