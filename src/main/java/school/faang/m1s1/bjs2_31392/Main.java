// Группировка пользователей по возрасту

package school.faang.m1s1.bjs2_31392;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User userOne = new User("Bruce", 40, "Wayne Corp", "Gotham");
        User userTwo = new User("Peter", 20, "Daily Bugle", "New York");
        User userThree = new User("Clark", 40, "Daily Planet", "Metropolis");
        User userFour = new User("Tony", 45, "Stark Enterprises", "New York");

        List<User> userList = new ArrayList<>(List.of(userOne, userTwo, userThree, userFour));


        System.out.println((User.groupUsers(userList)));
    }
}
