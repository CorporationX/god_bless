package school.faang.bjs2_85478;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (result.containsKey(age)) {
                List<User> list = result.get(age);
                list.add(user);
            } else {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                result.put(age, newList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Айдар", 25, "Курьер", "Уфа"));
        userList.add(new User("Маша", 21, "Визажист", "Москва"));
        userList.add(new User("Петр", 21, "Фрилансер", "Москва"));
        userList.add(new User("Зулейха", 24, "Повар", "Казань"));
        userList.add(new User("Катя", 21, "SMM", "Москва"));

        Map<Integer, List<User>> grouped = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            Integer age = entry.getKey();
            List<User> usersOfAge = entry.getValue();
            System.out.println("Возраст: " + age);
            for (User user : usersOfAge) {
                System.out.println("\t- " + user);
            }
        }
    }

    @Override
    public String toString() {
        return "Зовут: " + name + ','
                + " Возраст: " + age + '.'
                + " Работа: " + workplace + ','
                + " Адрес: " + address + '.';
    }
}
