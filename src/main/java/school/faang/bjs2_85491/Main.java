package school.faang.bjs2_85491;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Artem", 20, "спортсмен", "ну какой то адрес 1");
        User user2 = new User("Olga", 22, "программист", "ну какой то адрес 2");
        User user3 = new User("Oksana", 23, "певец", "ну какой то адрес 3");
        User user4 = new User("Vita", 25, "курьер", "ну какой то адрес 4");
        User user5 = new User("Mihail", 20, "рабочий", "ну какой то адрес 5");
        User user6 = new User("Artur", 23, "инженер", "ну какой то адрес 6");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        int findAge = 23;
        Map<Integer, List<User>> result = User.groupUsers(users, findAge);

        System.out.println("Find age: " + findAge);
        for (Map.Entry<Integer, List<User>> e : result.entrySet()) {
            for (User user : e.getValue()) {
                System.out.println("Name: " + user.getName() + ", Job: " + user.getJob() + ", Address: " + user.getAddress());
            }
        }
    }
}