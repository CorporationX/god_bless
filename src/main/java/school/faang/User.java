package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;



    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sort = new HashMap<>();
        for(User user : users) {
            sort.computeIfAbsent(user.getAge(), i -> new ArrayList<>()).add(user);
        }
        return sort;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
