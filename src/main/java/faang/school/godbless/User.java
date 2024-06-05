package faang.school.godbless;

import java.util.ArrayList;
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

        if (!userList.isEmpty()) {
            userList.forEach(user -> {
                if (user.getYear() != null) {
                    if (userMap.containsKey(user.getYear())) {
                        //тут не пойму как переписать в одну строку, мне же надо как-то в лист записать
                        List userNewList = userMap.get(user.getYear());
                        userNewList.add(user);
                        userMap.put(user.getYear(), userNewList);
//                    userMap.put(user.getYear(), user); но как передать лист?
                    } else {
                        userMap.put(user.getYear(), new ArrayList<>());
                    }
                }
            });
        }
        return userMap;
    }
}
