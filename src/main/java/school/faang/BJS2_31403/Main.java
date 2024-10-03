package school.faang.BJS2_31403;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User Alice = new User("Alice", 25, "Company A", "123 Main St");
        User Bob = new User("Bob", 30, "Company B", "456 Elm St");
        User Charlie = new User("Charlie", 25, "Company C", "789 Oak St");
        User David = new User("David", 40, "Company D", "101 Pine St");
        User Eve = new User("Eve", 35, "Company E", "202 Cedar St");
        User Frank = new User("Frank", 30, "Company F", "303 Maple St");

        List<User> users = new ArrayList<>(List.of(Alice, Bob, Charlie, David, Eve, Frank));

        Map<Integer, List<User>> ageUsersPairs = User.groupUsers(users);
        for (var entry: ageUsersPairs.entrySet()) {
            System.out.printf("Возраст людей в группе: %d\nСписок людей данной группы: %s\n\n",
                    entry.getKey(), entry.getValue().toString());
        }
    }
}
