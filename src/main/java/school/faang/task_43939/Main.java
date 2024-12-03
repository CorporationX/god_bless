package school.faang.task_43939;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> myUserList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            myUserList.add(user);
        }

        Map<Integer, List<User>> mySortedMap = User.groupUsers(myUserList);

        System.out.println(mySortedMap);
    }
}
