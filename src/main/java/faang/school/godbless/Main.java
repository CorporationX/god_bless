package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static faang.school.godbless.User.findHobbyLovers;


public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = new HashSet<>(Arrays.asList("боулинг", "футбол", "бег", "дайвинг", "серфинг"));
        Set<String> hobbies1 = new HashSet<>(Arrays.asList("петушинные бои", "йога", "дайвинг"));
        Set<String> hobbies2 = new HashSet<>(Arrays.asList("бег", "боулинг", "тик-ток"));

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Sam", 18, hobbies1));
        users.add(new User(2, "George", 20, hobbies2));

        Map<User, String> activitiesLover = findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : activitiesLover.entrySet()) {
            System.out.printf("Пользователь: %s %n  Активность: %s %n", entry.getKey().getName(), entry.getValue());
        }
    }
}
