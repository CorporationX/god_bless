package faang.school.godbless.GroupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private int age;
    private String name;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users)
    {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        users.forEach(user ->
        {
            int currentUserAge = user.getAge();

            if (groupedUsersByAge.containsKey(currentUserAge))
            {
                groupedUsersByAge.get(currentUserAge).add(user);
            }
            else
            {
                List<User> newGroup = new ArrayList<>();
                newGroup.add(user);
                groupedUsersByAge.put(currentUserAge, newGroup);
            }
        });
        return groupedUsersByAge;
    }

    //Для теста в Main
    @Override
    public String toString()
    {
        return String.format("%s: %d лет ", name, age);
    }
}

