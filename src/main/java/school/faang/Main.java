package school.faang;

import school.faang.bjs2_85593_grouping_users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //1. Создаем объекты Users
        User user1 = new User("Anton", 21);
        User user2 = new User("Jan", 18);
        User user3 = new User("Olga", 22);
        User user4 = new User("Goga", 21);
        User user5 = new User("Igor", 19);
        User user6 = new User("Masha", 22);
        User user7 = new User("Alex", 18);

        //2. Создаем из объектов Users коллекцию List
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        //3. Передаем полученную сгруппированную мапу в новую мапу для распечатки
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        //4. Печатаем мапу
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            // Получаем список пользователей для этого возраста
            List<User> userInGroupe = entry.getValue();
            // Цикл для печати имени пользователя
            for (User user : userInGroupe) {
                System.out.println(" - " + user.getName());
            }
        }

    }

}
