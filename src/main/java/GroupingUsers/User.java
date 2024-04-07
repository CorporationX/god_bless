package GroupingUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();

//      Способ 1
//      List<User> filterUsersList = new ArrayList<>();
//      while (!usersList.isEmpty()) {
//          int currentAge = usersList.get(0).age;
//
//          filterUsersList = (List<User>) usersList.stream().filter(entry -> (entry.age == currentAge)).toList();
//          mapUsers.put(currentAge, filterUsersList);
//
//          usersList.removeIf(user -> user.age == currentAge);
//      }

//      Способ 2
        while (!usersList.isEmpty()) {
            int currentAge = usersList.get(0).age;
            List<User> filterUsersList = new ArrayList<>();

            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).age == currentAge) {
                    filterUsersList.add(usersList.get(i));
                    usersList.remove(usersList.get(i));
                    i--;
                }
            }
            mapUsers.put(currentAge, filterUsersList);
        }

        return mapUsers;
    }

}
