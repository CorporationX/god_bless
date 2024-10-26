package school.faang.synchronizedthreads3;

import java.util.ArrayList;
import java.util.List;

public class GameOfThronesApp {
    public static void main(String[] args) {

        List<String> roles = new ArrayList<>();
        roles.add("Lord");
        roles.add("Knight");
        roles.add("Mage");

        House house = new House(roles);

        for (int i = 1; i <= 5; i++) {
            User user = new User("User" + i);
            user.start();
            user.joinHouse(house);
        }
    }
}
