package school.faang.BJS2_43951;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grUser = new HashMap<>();


        if (users != null) {

            for (User user : users) {

                if (!grUser.containsKey(user.age)) {
                    grUser.put(user.age, new ArrayList<>());
                }
                grUser.get(user.age).add(user);
            }
        }


        return grUser;
    }

    public static String createRandomNameWorkplaceAddress(int length) {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
