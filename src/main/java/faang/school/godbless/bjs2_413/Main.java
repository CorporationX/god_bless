package faang.school.godbless.bjs2_413;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Anton", 23, "Google", "London");
        User user2 = new User("Roma", 44,"Yandex", "Moscow");
        User user3 = new User("Igor", 16, "Uber", "Amsterdam");
        User user4 = new User("Maks", 19, "Amazon", "New York");
        User user5 = new User("Anton", 23, "Google", "London");
        User user6 = new User("Anton", 33, "Uber", "Sochi");


        List < User > users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        System.out.println(User.groupUsers(users));
    }
}
