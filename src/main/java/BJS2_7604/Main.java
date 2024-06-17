package BJS2_7604;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = getCompletedList();
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        String ageTemplate = "In age %d contains this users: \n";
        groupedUsers.forEach((k, v) -> {
            System.out.printf(ageTemplate, k);
            v.forEach(System.out::println);
        });
    }

    static List<User> getCompletedList() {
        List<User> completedUsers = new ArrayList<>();

        completedUsers.add(new User());
        completedUsers.add(new User("Сергей", 33, "Лестатуя", "Саратов"));
        completedUsers.add(new User("Андрей", 33, "ТехноНефть", "Саратов"));
        completedUsers.add(new User("Дмитрий", 48, "Групп аг", "Москва"));
        completedUsers.add(new User("Роман", 30, "Сбер", "Москва"));
        completedUsers.add(new User("Антон", 30, "Групп рус", "Москва"));
        completedUsers.add(new User("Михаил", 30, "МТС", "Москва"));

        return completedUsers;
    }
}
