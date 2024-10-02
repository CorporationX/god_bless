package school.faang.usersgroup;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Users {
    private String name;
    private Integer age;
    private String workPlace;
    private String address;

    public Users(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Map<Integer,ArrayList<Users>> groupUsers(List<Users> list) {
        Map<Integer, ArrayList<Users>> usersHashMap = new HashMap<>();
            for (Users usersList: list) {
                usersHashMap.computeIfAbsent(usersList.getAge(), user -> new ArrayList<>()).add(usersList);
            }
        return usersHashMap;
    }
}
