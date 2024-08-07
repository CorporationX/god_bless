package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");


        Map<String, House> greatHouses = new HashMap<>();

        House house1 = new House("Stark", "Wolf");
        House house2 = new House("Barateon", "Deer");
        House house3 = new House("Grayjoy", "Kraken");
        House house4 = new House("Lanister", "Lion");
        House house5 = new House("Tirel", "Rose");
        House house6 = new House("Martell", "Sun");

        House.addHouse(greatHouses, house1);
        House.addHouse(greatHouses, house2);
        House.addHouse(greatHouses, house3);
        House.addHouse(greatHouses, house4);
        House.addHouse(greatHouses, house5);
        House.addHouse(greatHouses, house6);

        House.getAllHouses(greatHouses);
        System.out.println();

        House.delHouse(greatHouses, "Lanister");

        House.getAllHouses(greatHouses);

        House.getHouse(greatHouses, "Stark");

        User us1 = new User(1, 15, "Nemo", Set.of("Курение", "Алкоголизм"));
        User us2 = new User(2, 25, "Vladislav", Set.of("Программирование", "Отжимания"));
        User us3 = new User(3, 17, "Stepan", Set.of("Работа", "Отжимания"));
        User us4 = new User(4, 25, "Alexandr", Set.of("Работа", "Алкоголизм"));

        List<User> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);

        Set<String> goodHabits = Set.of("Программирование", "Отжимания", "Работа");

        System.out.println(User.findHobbyLovers(users, goodHabits));

    }
}