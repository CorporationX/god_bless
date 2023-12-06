package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(20, "Jackson", "Google", "New York");
        User u2 = new User(35, "Don", "Uber", "Amsterdam");
        User u3 = new User(18, "Rauan", "Amazon", "London");
        User u4 = new User(18, "RauanIO", "Amazon", "Amsterdam");
        List<User> listOfUSERS = new ArrayList<>();
        listOfUSERS.add(u1);
        listOfUSERS.add(u2);
        listOfUSERS.add(u3);
        listOfUSERS.add(u4);
        System.out.println(User.groupUsers(listOfUSERS));
    }
}
