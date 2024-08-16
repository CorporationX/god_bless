package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Max");
        user1.setAge(22);
        user1.setAddress("Russia");
        user1.setPlaceOfWork("teacher");

        User user2 = new User();
        user2.setName("Anna");
        user2.setAge(25);
        user2.setAddress("USA");
        user2.setPlaceOfWork("teacher");

        User user3 = new User();
        user3.setName("Andrei");
        user3.setAge(22);
        user3.setAddress("Canada");
        user3.setPlaceOfWork("Developer");


        List<User> users = new ArrayList<>();
        users = Arrays.asList(user1, user2, user3);
        Map<Integer, ArrayList> ageGroup = User.groupUsers(users);
        for (Map.Entry<Integer, ArrayList> entry : ageGroup.entrySet()) {
            System.out.println("Возраст: " + entry.getKey() + " - Пользователи: " + entry.getValue());
        }



    }

}
