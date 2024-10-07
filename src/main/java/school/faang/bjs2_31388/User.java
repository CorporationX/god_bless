package school.faang.bjs2_31388;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        if (users == null || users.isEmpty() ) {
            return new HashMap<Integer, List<User>>() ;
        }
        for (User user : users) {
            usersByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            usersByAge.get(user.getAge()).add(user);
        }
        return usersByAge;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                "}\n";
    }
}
