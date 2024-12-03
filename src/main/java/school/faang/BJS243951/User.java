package school.faang.BJS243951;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users, String groupeBy) {
        Map<Integer, List<User>> grUser = new HashMap<>();


        String grpBy = groupeBy;

        if (grpBy == "name") {
            grpBy = "name";
        } else if (grpBy == "age") {
            grpBy = "age";
        } else if (grpBy == "workplace") {
            grpBy = "workplace";
        } else if (grpBy == "address") {
            grpBy = "address";
        } else new RuntimeException("ds");

        if (grpBy == "age") {

            for (User user : users) {

                if (!grUser.containsKey(user.age)) {
                    grUser.put(user.age, new ArrayList<>());
                    grUser.get(user.age).add(user);
                }else grUser.get(user.age).add(user);
            }
        }


        return grUser;
    }

    public static String createRandomNameWorkplaceAdress(int length) {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        return generatedString;
    }
}
