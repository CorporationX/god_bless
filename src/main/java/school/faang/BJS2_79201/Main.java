package school.faang.BJS2_79201;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Jon", 20, "123", "123"));
        userList.add(new User("Mark", 20, "123", "123"));
        userList.add(new User("Aleks", 20, "123", "123"));
        userList.add(new User("Marry", 21, "123", "123"));
        userList.add(new User("Sue", 21, "123", "123"));
        userList.add(new User("Ned", 22, "123", "123"));

        Map<Integer, List<User>> userMap;
        userMap = User.groupUser(userList);

        for (Map.Entry<Integer, List<User>> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + getNameList(entry.getValue()));
        }
    }

    private static List<String> getNameList(List<User> userList) {
        List<String> nameList = new ArrayList<>();
        for (User user : userList) {
            nameList.add(user.getName());
        }
        return nameList;
    }
}