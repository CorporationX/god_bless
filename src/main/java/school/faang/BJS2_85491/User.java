package school.faang.bjs2_85491;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupByAge = new HashMap<>();

        for (User user : users) {
            if (user != null && user.getAge() != null) {
                userGroupByAge.putIfAbsent(user.getAge(), new ArrayList<>());
                userGroupByAge.get(user.getAge()).add(user);
            }
        }

        return userGroupByAge;
    }
<<<<<<< HEAD
=======

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }
>>>>>>> f5f3693b5e5c4527dfd1a59d5a05afe509e00fc8
}
