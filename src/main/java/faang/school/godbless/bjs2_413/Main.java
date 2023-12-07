package faang.school.godbless.bjs2_413;

import java.util.List;
import java.util.Map;

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

//        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
//            System.out.println( entry.getKey() +" - " + entry.getValue().toString());
////        }
        Map<Integer, List<User>> groupAge = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupAge.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName() + " ");
              }
            System.out.println("\n");
        }
    }
}