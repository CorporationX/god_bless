package faang.school.godbless.grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Users {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    // методо для группировки пользователей по возрасту
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
