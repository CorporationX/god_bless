package school.faang.task_bjs243948;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Igor", 31, "It", 134267);
        User user2 = new User("Lena", 25, "It", 134268);
        User user3 = new User("Kirill", 25, "It", 134269);
        User user4 = new User("Yana", 32, "It", 134270);
        User user5 = new User("Polina", 21, "It", 134271);
        User user6 = new User("Danya", 26, "It", 134272);
        User user7 = new User("Mariya", 21, "It", 134273);
        User user8 = new User("Irina", 31, "It", 134274);
        User user9 = new User("Yana", 21, "It", 134275);
        User user10 = new User("Edward", 17, "Doctor", 666666);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        System.out.println(User.groupUsers(users));
    }
}
