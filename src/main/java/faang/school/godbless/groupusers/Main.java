package faang.school.godbless.groupusers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 25, "CompanyA", "Address1"));
        users.add(new User("Alice", 30, "CompanyB", "Address2"));
        users.add(new User("Bob", 25, "CompanyC", "Address3"));
        users.add(new User("Eve", 30, "CompanyA", "Address4"));
        Map<Integer, List<User>> usersMap = User.groupUsers(users);
        for (var entry : usersMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var user : entry.getValue()) {
                System.out.println(user.getName());
            }
            System.out.println();
        }
    }
}
