package faang.school.godbless.task_001;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User implements Cloneable {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    /**
     * Группирует пользователей по возрасту.
     *
     * @param users - список пользователей
     * @return - сгруппированная Map'а. (в качестве ключа возраст)
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            Integer ageFilter = user.getAge();

            // Если возсрастной группа ещё нет,
            if (!groupUsers.containsKey(ageFilter)) {
                // то добавляем группу(ключ) и пустой список
                groupUsers.put(ageFilter, new ArrayList<>());
            }

            // добавляем пользователя в группу.
            groupUsers.get(ageFilter).add(copyUser(user));
        }
        return groupUsers;
    }

    /**
     * Копирует пользователя, чтобы в последствии вернуть Map'у объектов
     * не связанных с оригиналом.
     *
     * @param user - пользователь для копирования.
     * @return - копия пользователя.
     */
    private static User copyUser(User user) {
        try {
            return (User) user.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
