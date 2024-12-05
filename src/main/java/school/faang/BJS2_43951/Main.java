package school.faang.BJS2_43951;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Main {

    public final static int COUNT_RANDOM_COUNT_FROM = 300;

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(COUNT_RANDOM_COUNT_FROM); i++) {
            User user = new User(
                    User.createRandomNameWorkplaceAddress(new Random().nextInt(1, 10)),
                    new Random().nextInt(9, 21),
                    User.createRandomNameWorkplaceAddress(6),
                    User.createRandomNameWorkplaceAddress(10)
            );
            users.add(user);

        }


        Map<Integer, List<User>> groupedUser = User.groupUsers(users, "age");


        for (Map.Entry<Integer, List<User>> entry : groupedUser.entrySet()) {
            System.out.print(entry.getKey() + "\n");

            for (User user : entry.getValue()) {
                System.out.print(" " + user.toString() + "\n");
            }
            System.out.print(", ");
            System.out.print("\n\n");
        }

    }
}