package group_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static group_users_by_age.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User bill = new User("Bill", 23, "Apple", "Los Angeles");
        User anton = new User("Anton", 24, "VTB", "Moscow");
        User marat = new User("Marat", 35, "Sber", "Moscow");

        List<User> userList = new ArrayList<>();
        userList.add(bill);
        userList.add(anton);
        userList.add(marat);

        System.out.println(groupUsers(userList));


    }
}
