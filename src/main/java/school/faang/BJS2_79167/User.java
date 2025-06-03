package school.faang.BJS2_79167;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> checkUsers) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : checkUsers) {
            int age = user.getAge();
            result.putIfAbsent(age, new ArrayList<>());
            result.get(age).add(user);
        }
        return result;
    }
}
//            if (!result.containsKey(age)) {
//                result.put(age, new ArrayList<>());
//            }
//            result.get(age).add(user);
//        }

//    public User(String name, int age, String workplace, String address) {
//        this.name = name;
//        this.age = age;
//        this.workplace = workplace;
//        this.address = address;
//    }

//    public int getAge() {
//        return age;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", workplace='" + workplace + '\'' +
//                ", address='" + address + '\'' +
//                '}';