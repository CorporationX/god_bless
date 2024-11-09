package school.faang.GroupUsers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<user> users = new ArrayList<>();
        users.add(new user("Alice", 25, "Google", "California"));
        users.add(new user("Bob", 30, "Amazon", "Washington"));
        users.add(new user("Rob", 25, "Netflix", "California")); // добавлена дважды
        users.add(new user("Charlie", 25, "Facebook", "New York"));
        users.add(new user("Daisy", 35, "Apple", "California"));

        Map<Integer, List<user>> groupedUsers = user.groupUsers(users);

        for (Map.Entry<Integer, List<user>> entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<user> usersWithSameAge = entry.getValue();
            System.out.println("Возраст: " + age);

            for (user user : usersWithSameAge) {
                System.out.println("имя: " + user.getN() + ", Работает в: " + user.getWorkplace() + ", Адрес: " + user.getAddress());
            }
        }

        if (groupedUsers.size() == 0) {
            System.out.println("Нет сгруппированных пользователей.");
        }
    }
}