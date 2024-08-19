package faang.school.godbless.BJS2_436;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(new User(20, "Jackson", "Google", "New York"));
        listOfUsers.add(new User(35, "Don", "Uber", "Amsterdam"));
        listOfUsers.add(new User(18, "Rauan", "Amazon", "London"));
        listOfUsers.add(new User(18, "Fedor", "Amazon", "Amsterdam"));
        System.out.println(User.groupUsers(listOfUsers));
    }
}
