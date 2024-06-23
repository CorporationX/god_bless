package faang.school.godbless.sprint_1.java_core.task_001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String placework, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            Integer ageFilter = user.age();

            // Если возсрастной группа ещё нет,
            if (!groupUsers.containsKey(ageFilter)) {
                // то добавляем группу(ключ) и пустой список
                groupUsers.put(ageFilter, new ArrayList<>());
            }

            // добавляем пользователя в группу.
            groupUsers.get(ageFilter).add(user);
        }

        return groupUsers;
    }

}
