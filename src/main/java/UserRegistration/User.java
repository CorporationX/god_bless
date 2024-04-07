package UserRegistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String workPlace, String adress) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("имя пользователя не должно быть пустым");
        } else if (age < 18) {
            throw new IllegalArgumentException("Возраст пользователя должен быть не меньше 18ти");
        } else if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Место работы пользователя должно быть из списка: Google, Uber, Amazon");
        } else if (!VALID_ADDRESSES.contains(adress)) {
            throw new IllegalArgumentException("Адрес пользователя должен быть из списка: London, New York, Amsterdam");
        } else {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.adress = adress;
        }
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
