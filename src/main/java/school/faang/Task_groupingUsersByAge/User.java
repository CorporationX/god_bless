package school.faang.Task_groupingUsersByAge;


import lombok.Data;
import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Требования задачи:
 *  Создать класс User с полями:
 * <p>
 * name — имя пользователя;
 * <p>
 * age — возраст пользователя;
 * <p>
 * workplace — место работы пользователя;
 * <p>
 * address — адрес пользователя.
 * <p>
 * Добавить в класс User статический метод groupUsers(List‹User›), который:
 * <p>
 * Принимает список объектов класса User.
 * <p>
 * Возвращает Map‹Integer, List‹User››, где: ключ — возраст пользователя; значение — список всех пользователей из исходного списка с этим возрастом.
 * <p>
 * Реализовать метод main():
 * <p>
 * Создать список из нескольких объектов класса User.
 * <p>
 * Вызвать метод groupUsers и вывести результат на экран.
 */

@Data
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;
    public  User(String name, int age, String workplace, String address) {
    this.name = name;
    this.age = age;
    this.workplace = workplace;
    this.address = address;
}
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User currentUser : users) {
            int age = currentUser.getAge();
                if (!groupedUsers.containsKey(age)) {
                    groupedUsers.put(age, new ArrayList<>());
                }
            groupedUsers.get(age).add(currentUser);
        }
        return groupedUsers;
    }
}
