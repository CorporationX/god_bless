package faang.school.godbless.JavaCore;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    public static void main(String[] args) {

        User user1 = new User("Vadim", 29, "Shibanov", "Moscow");
        User user2 = new User("Mike", 88, "Black", "Ohio");
        User user3 = new User("Jessica", 29, "Smith", "London");
        User user4 = new User("Danny", 44, "O'Brien", "New-York");
        User user5 = new User("Clare", 29, "Noname", "Moscow");
        User user6 = new User("Vadim", 29, "Shibanov", "Moscow");

        List<User> list = new ArrayList<>();

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);


        Map<Integer, List<User>> map = groupUsers(list);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<User> listOfUsers = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + listOfUsers.toString());
        }
    }

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> listMap = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            List<User> list = new ArrayList<>();
            Integer age = users.get(i).getAge();

            for (int j = 0; j < users.size(); j++) {

                if (users.get(j).getAge() == age) {
                    list.add(users.get(j));
                }
            }
            listMap.put(age, list);
        }
        return listMap;
    }
}
