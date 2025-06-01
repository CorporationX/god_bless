package school.faang.bjs2_79164;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Steve", 18, "Game", "Россия, г. Самара, ул. Первого мая");
        User user2 = new User("Nikita", 19, "Student", "Россия, г. Петергоф, ул. Ботаническая");
        User user3 = new User("Jonh", 29, "Yandex", "Россия, г. Москва, ул. 40 лет октября");
        User user4 = new User("Alex", 19, "Yadro", "Россия, г. Елец, ул. Школьная");
        User user5 = new User("Mike", 29, "Google", "США, г. Нью-Йорк, ул. Уолл Стрит");
        User user6 = new User("Peter", 29, "DataArt", "Россия, г. Борисоглебск, ул. Юбилейная");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Map<Integer, List<User>> groupUsersByAge = User.groupUsers(users);

        System.out.println(groupUsersByAge);
    }
}
