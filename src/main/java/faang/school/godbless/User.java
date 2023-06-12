package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List> groupUsers(List<User> users) {
        Map<Integer, List> usersByAge = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if(usersByAge.containsKey(userAge)){
                usersByAge.get(userAge).add(user);
            }else{
                usersByAge.put(userAge, new ArrayList(Arrays.asList(user)));
            }
        }
        return usersByAge;
    }

    public int getAge() {
        return age;
    }
}
