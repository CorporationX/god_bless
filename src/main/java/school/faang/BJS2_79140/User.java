package school.faang.BJS2_79140;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    static public Map<Integer, List<User>> groupUsers(List<User> inputList) {
        Map<Integer, List<User>> sortedMap = new HashMap<>();

        for (User user : inputList) {
            int age = user.getAge();

            if(!sortedMap.containsKey(age)){
                sortedMap.put(age, new ArrayList<>());
            }
            sortedMap.get(age).add(user);
        }
        return sortedMap;
    }
}
