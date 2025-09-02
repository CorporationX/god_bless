package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String work;
    private String address;

   @SuppressWarnings({"checkstyle:Indentation", "checkstyle:GenericWhitespace"})
   public static HashMap <Integer, List<String>> groupUsers(List<User> users) {
       HashMap <Integer, List<String>> ageUsers = new HashMap<>();
        for (User user : users) {
            List<String> userList = new ArrayList<>();
            for (User user1 : users) {
                if (user.age == user1.age) {
                    userList.add(user1.name);
                }
            }
            ageUsers.put(user.age, userList);
        }
        return ageUsers;
   }
}
