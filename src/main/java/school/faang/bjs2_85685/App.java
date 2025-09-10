package school.faang.bjs2_85685;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        User userNikolay = new User("Nikolay", 22, "IT", "Pushkin street");
        User userAnton = new User("Anton", 23, "School", "Lermontov street");
        User userNina = new User("Nina", 22, "University", "Tolstoy street");
        User userEgor = new User("Egor", 23, "IT", "Dostoevskiy street");
        User userNastya = new User("Nastya", 35, "Bakery", "Nikrasov street");
        User userVlad = new User("Vlad", 35, "IT", "Duma street");

        final List<User> users = new ArrayList<>(List
                .of(userNikolay, userAnton, userNina, userEgor, userNastya, userVlad));

        final Map<Integer, List<User>> map = User.groupUsers(users);

        System.out.println(map);
    }
}