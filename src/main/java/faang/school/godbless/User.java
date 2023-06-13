package faang.school.godbless;
import java.util.*;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getAge() {
        return this.age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> res = new HashMap<>();
        for(User user : userList) {
            int age = user.getAge();
            res.computeIfPresent(age, (key, value) -> {
                value.add(user);
                return value;
            });
            if(!res.containsKey(age)) {
                List<User> list = new ArrayList<>();
                list.add(user);
                res.put(age, list);
            }

        }
        return res;
    }
}
