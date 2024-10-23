package school.faang.bjs2_37367;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User user1 = new User("Nick95");
        User user2 = new User("Zlomilk_84");
        User user3 = new User("To_TO-xd");
        User user4 = new User("Fool(0_0)");
        User user5 = new User("AZA_za95424");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        Player playerSpotify = new Player();
        ThreadExecutor threadExecutor = new ThreadExecutor(playerSpotify, userList);
        threadExecutor.execute();
    }
}
