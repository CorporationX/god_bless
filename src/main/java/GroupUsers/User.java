package GroupUsers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    final List<String> VALID_JOBS = List.of("Google", "Amazon", "Uber");
    final List<String>VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) throws Exception {
        this.name = name;
        if(name.isEmpty() || age <18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
        else {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageUserList = new HashMap<>();

        for (User u : userList) {
            int key = u.getAge();
            if(!ageUserList.containsKey(key)) {
                List<User> testList = new ArrayList<>();
                testList.add(u);
                ageUserList.put(key,testList);
            }
            else {
                ageUserList.get(key).add(u);
            }
        }

        return ageUserList;
    }
}
