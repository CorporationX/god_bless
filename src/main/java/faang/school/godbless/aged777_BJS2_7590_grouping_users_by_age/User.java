package faang.school.godbless.aged777_BJS2_7590_grouping_users_by_age;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
record User(String name, @Getter int age, String placeOfWork, String address) {

    /**
     * Метод для определения пользователей нужного возраста
     *
     * @param users      - принимаемый список пользователей
     * @param desiredAge - искомый возраст пользователей
     * @return - метод возвращает коллекцию Map, в которой ключ - переданный возраст, значение - список пользователей
     * данного возраста, если пользователей такого возраста нет, метод выведет в консоль сообщение:
     * "Пользователей искомого возраста не найдено."
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users, int desiredAge) {
        Map<Integer, List<User>> result = new HashMap<>();
        List<User> usersOfDesiredAge = new ArrayList<>();

        for (User currentUser : users) {
            if (currentUser.getAge() == desiredAge) {
                usersOfDesiredAge.add(currentUser);
            }
        }

        if (usersOfDesiredAge.isEmpty()) {
            System.out.println("Пользователей искомого возраста не найдено.");
            return result; // Map<desiredAge, null>
        }

        result.put(desiredAge, usersOfDesiredAge);

        return result;
    }

}
