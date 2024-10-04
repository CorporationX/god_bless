package school.faang;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class User {
    private String name;
    private String age;
    private String job;
    private String address;

    public User() {

    }

    public User(String name, String age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> mapByAge = new HashMap<>();
        List<User> listByAge = new ArrayList<>();
        for (User user : users) {
            if (user.age.equals(this.age)) {
                listByAge.add(user);
                System.out.println("Закинул " + user.name + "\n");
            }
        }
        mapByAge.put(this.age,listByAge);
        return  mapByAge;

    }


}

