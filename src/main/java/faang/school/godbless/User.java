package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private Integer year;
    private String department;
    private String adress;

    public User(String name, Integer year, String department, String adress) {
        this.name = name;
        this.year = year;
        this.department = department;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }

    public String getAdress() {
        return adress;
    }

    public static HashMap<Integer, List<User>> groupUser(List<User> userList) {
        HashMap<Integer, List<User>> userMap = new HashMap<>();

        if (!userList.isEmpty() && userList != null) {
            userList.forEach(user -> {
                if (user.getYear() != null) {
                    if (userMap.containsKey(user.getYear())) {
                        userMap.get(user.getYear()).add(user);
                    } else {
                        userMap.put(user.getYear(), new ArrayList<>(Arrays.asList(user)));
                    }
                }
            });
        }
        return userMap;
    }
}