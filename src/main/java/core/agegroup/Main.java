package core.agegroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        User viktor = new User("Viktor", 18, "Google", "Moscow");
        User daniil = new User("Daniil", 19, "Yandex", "London");
        User sergey = new User("Sergey", 19, "Uber", "Kiev");
        User marat = new User("Marat", 18, "Yandex", "Montreal");
        User oleg = new User("Oleg", 18, "Uber", "Toronto");

        usersList.add(viktor);
        usersList.add(daniil);
        usersList.add(sergey);
        usersList.add(marat);
        usersList.add(oleg);
        Map<Integer, List<User>> ageGroup = User.groupUsers(usersList);
        System.out.println(ageGroup);
    }
}
