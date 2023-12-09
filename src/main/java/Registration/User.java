package Registration;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.HashSet.newHashSet;

@Getter
@Setter
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>() {{
        add("Google");
        add("Uber");
        add("Amazon");
    }};
    private static final Set<String> VALID_ADDRESSES = new HashSet<>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};

    private String name;
    private int age;
    private String workCompany;
    private String address;

    public User(String name, int age, String workCompany, String address) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(workCompany)) {
            throw new IllegalArgumentException("The job should be on the list");
        } else {
            this.workCompany = workCompany;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address should be on the list");
        } else {
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        //Создаем мапу, которую выведем в конце метода
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        //Создаем временное хранилище для добавления пользователей
        List<User> temp;

        for (User user : users) {
            //Получаем доступ к листу по текущему ключу
            temp = groupedUsers.getOrDefault(user.getAge(), new ArrayList<>());
            temp.add(user);
            groupedUsers.put(user.getAge(), temp);
        }
        return groupedUsers;
    }
}