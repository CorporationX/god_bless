package faang.school.godbless.module1.sprint1.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 18, "Yandex", "Go-Developer"));
        users.add(new User("Max", 36, "Amazon", "Java-Developer"));
        users.add(new User("Tom", 18, "Google", "Project manager"));
        users.add(new User("Mary", 20, "Sber-bank", "Team Lead"));

        printAllStudents(groupUsers(users));
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groups = new HashMap<>();
        for (User user : users) {
            groups.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groups;
    }

    public static void printAllStudents(Map<Integer, List<User>> groups) {
        for (Map.Entry<Integer, List<User>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
