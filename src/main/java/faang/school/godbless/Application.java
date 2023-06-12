package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String... args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                users.add(new User(Integer.toString(i),i%3,Integer.toString(i),Integer.toString(i)));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(users);
        System.out.println(User.groupUsers(users));
    }
}

