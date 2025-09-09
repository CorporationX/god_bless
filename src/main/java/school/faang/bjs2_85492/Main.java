package school.faang.bjs2_85492;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Ваня", 28, Set.of("велосипед", "футбол")));
        users.add(new User(2, "Аня",  32, Set.of("танцы", "кино")));
        users.add(new User(3, "Леша", 25, Set.of("футбол", "баскетбол")));
        users.add(new User(4, "Вика", 25, Set.of("шахматы", "бег")));

        Set<String> targetActivities = Set.of("футбол", "кино");
        Map<String, String> interestUser = User.findHobbyLovers(users, targetActivities);
        System.out.println(interestUser);
    }
}
