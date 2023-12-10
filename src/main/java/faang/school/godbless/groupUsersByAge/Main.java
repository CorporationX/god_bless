package faang.school.godbless.groupUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, List<User>> group = User.groupUsers(createUsers());

        for (Map.Entry<Integer, List<User>> entry : group.entrySet()) {
            Integer key = entry.getKey();
            List<User> users = entry.getValue();

            System.out.print(key + " - ");
            StringBuilder usersName = new StringBuilder();
            for (User user : users) {
                usersName.append(user.getName()).append(" ");
            }
            System.out.println(usersName.toString().trim());
        }
    }

    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("John", 32, "Amazon", "Amsterdam"));
        users.add(new User("Erick", 32, "Google", "New_York"));

        users.add(new User("Bred", 31, "Uber", "London"));
        users.add(new User("John", 31, "Google", "New_York"));

        users.add(new User("Seth", 30, "Amazon", "Amsterdam"));
        users.add(new User("Palmer", 30, "Amazon", "New_York"));

        users.add(new User("Eddy", 35, "Amazon", "Amsterdam"));
        users.add(new User("Christopher", 35, "Google", "New_York"));

        users.add(new User("Kenny", 28, "Amazon", "Amsterdam"));
        users.add(new User("Collin", 28, "Google", "New_York"));

//        users.add(new User("Little", 17, "Ozon", "Moscow"));
//        users.add(new User("Big", 19, "OzonGroup", "Saint-Petersburg"));


        return users;
    }
}
