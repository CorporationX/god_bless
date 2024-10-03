package school.faang;

import school.faang.BJS2_31618.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User Alice = new User("Alice", 25, "Google", "London");
        User Bob = new User("Bob", 30, "Uber", "New York");
        User Charlie = new User("Charlie", 25, "Amazon", "Amsterdam");
        User David = new User("David", 40, "Google", "New York");
        User Eve = new User("Eve", 35, "Uber", "Amsterdam");
        User Frank = new User("Frank", 30, "Amazon", "London");

        List<User> users = new ArrayList<>(List.of(Alice, Bob, Charlie, David, Eve, Frank));

        Map<Integer, List<User>> ageUsersPairs = User.groupUsers(users);
        for (var entry: ageUsersPairs.entrySet()) {
            System.out.printf("Возраст людей в группе: %d\nСписок людей данной группы: %s\n\n",
                    entry.getKey(), entry.getValue().toString());
        }
    }
}
