package faang.school.godbless.groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    /*private static HashMap<Integer, List<User>> groupUser(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();


        for (User user : userList) {

            List<User> nextList = new ArrayList<>();

            //userMap.computeIfAbsent(user.getAge(), nextList.add(user));

        }


        return userMap;

    }

    /*public static void addUser (User u){
        List<User> nextList = new LinkedList<>();
        nextList.add(u);
    }*/


}