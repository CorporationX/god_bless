package school.faang.bjs2_85703;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User gangster = new User("John", 32, "street", "Times Square");
        User singer = new User("Richard", 23, "studio", "Grand Canyon");
        User dancer = new User("Alex", 56, "dance_studio", "Sequoia National Park");
        User hardWorker = new User("Michael", 44, "office", "Washington Monument");

        List<User> users = new ArrayList<>();
        users.add(gangster);
        users.add(singer);
        users.add(dancer);
        users.add(hardWorker);

        var groupedList = User.groupByUserAge(users);

        groupedList.forEach((age, userList) -> {
            System.out.println(age + ": " + userList);
        });
    }
}
