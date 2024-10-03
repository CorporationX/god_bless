package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public User(User other) {
        this(other.getName(), other.getAge(), other.getPlaceOfWork(), other.getAddress());
    }

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupResult = new HashMap<Integer, List<User>>();

        for (User user : users) {
            var group = groupResult.computeIfAbsent(user.getAge(), key -> new ArrayList<>());
            group.add(new User(user));
        }

        return groupResult;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'';
    }
}
