package faang.school.godbless.bjs2_413;

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


        List<User> users = List.of(user1, user2, user3, user4);

        User.groupUsers(users);
        for (User user : users) {
            System.out.println(user.getAge() + " - " + user.getName());
        }
    }
}
