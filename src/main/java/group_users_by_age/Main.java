package group_users_by_age;

import java.util.ArrayList;
import java.util.List;

import static group_users_by_age.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User bill = new User("Bill", 23, "Google", "London");
        User anton = new User("Anton", 24, "Uber", "New York");
        User marat = new User("Marat", 35, "Amazon", "Amsterdam");

        List<User> userList = new ArrayList<>();
        userList.add(bill);
        userList.add(anton);
        userList.add(marat);

        System.out.println(groupUsers(userList));

        User tom = new User("Tom", 18, "Amazon", "Voronesh");


    }
}
