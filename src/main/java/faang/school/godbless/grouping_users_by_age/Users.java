package faang.school.godbless.grouping_users_by_age;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Users {

    static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );
    static final int AGE_LIMIT = 18;
    private String name;
    private int age;
    private String placeOfWork;
    private String address;


    public Users(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (age >= AGE_LIMIT) {
            throw new IllegalArgumentException("age under 18");
        } else if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("job not on the list");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address not on the list");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    // метод для группировки пользователей по возрасту
    public static HashMap<Integer, List<Users>> groupUsers(List<Users> users) {

        // создаем хэшмап куда будем складывать пользователей
        HashMap<Integer, List<Users>> usersByAge = new HashMap<>();

        // перебираем пользователей
        for (Users user : users) {

            int age = user.getAge();

            // проверяем есть ли наша возрастная группа
            boolean groupExist = false;
            for (Map.Entry<Integer, List<Users>> entry : usersByAge.entrySet()) {
                if (entry.getKey() == age) {
                    groupExist = true;
                    break;
                }
            }

            // если нет определенной возрастной группы, тогда ее создаем
            // если есть, просто добавлем в нее нового пользователя
            if (!groupExist) {
                usersByAge.put(age, new ArrayList<>());
                usersByAge.get(age).add(user);
            } else {
                usersByAge.get(age).add(user);
            }
        }

        return usersByAge;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", age:" + this.age + ", place of work: " + this.placeOfWork +
                ", address: " + this.address;
    }
}
