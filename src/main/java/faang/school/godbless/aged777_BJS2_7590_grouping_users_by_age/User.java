package faang.school.godbless.aged777_BJS2_7590_grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    /**
     * Метод для определения пользователей нужного возраста
     * @param users - принимаемый список пользователей
     * @param desiredAge - искомый возраст пользователей
     * @return - метод возвращает коллекцию Map, в которой ключ - переданный возраст, значение - список пользователей
     *           данного возраста, если пользователей такого возраста нет, метод выведет в консоль сообщение:
     *           "Пользователей искомого возраста не найдено."
     */
    public static Map<Integer, List<User>> groupUsers (List <User> users, int desiredAge) {
        Map<Integer, List<User>> resultMap = new HashMap<>();
        List<User> usersOfDesiredAge = new ArrayList<>();

        for (User currentUser : users) {
            if (currentUser.getAge() == desiredAge) {
                usersOfDesiredAge.add(currentUser);
            }
        }

        if (usersOfDesiredAge.isEmpty()) {
            System.out.println("Пользователей искомого возраста не найдено.");
            return resultMap; // Map<desiredAge, null>
        }

        resultMap.put(desiredAge, usersOfDesiredAge);

        return resultMap;
    }

}
