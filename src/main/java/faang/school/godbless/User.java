package faang.school.godbless;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + '\'' + age + '\'' + workPlace + '\''  + address + '\'';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> resultGroupUsers = new HashMap<>();
        for (User user:users) {
            List<User> userList = new ArrayList<>();
            if (resultGroupUsers.containsKey(user.getAge())){
                for (Map.Entry<Integer, List<User>> mapResultGroupUsers:resultGroupUsers.entrySet()) {
                    if (mapResultGroupUsers.getKey() == user.getAge()){
                        mapResultGroupUsers.getValue().add(user);
                    }
                }
            }else {
                userList.add(user);
                resultGroupUsers.put(user.getAge(), userList);
            }
        }return resultGroupUsers;

    }
}
