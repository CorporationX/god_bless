package school.faang.task_56372;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vladimir", 34, "Yandex", "Ufa"));
        users.add(new User("Anna", 28, "Google", "Moscow"));
        users.add(new User("Sergey", 40, "Mail.ru", "Saint Petersburg"));
        users.add(new User("Dmitry", 25, "Facebook", "Kazan"));
        users.add(new User("Maria", 30, "Twitter", "Novosibirsk"));
        users.add(new User("Igor", 30, "Apple", "Yekaterinburg"));
        users.add(new User("Olga", 29, "Microsoft", "Nizhny Novgorod"));
        users.add(new User("Alexey", 35, "Huawei", "Chelyabinsk"));
        users.add(new User("Natalia", 31, "Samsung", "Rostov-on-Don"));
        users.add(new User("Andrey", 27, "IBM", "Voronezh"));
        users.add(new User("Ekaterina", 33, "Intel", "Krasnoyarsk"));
        users.add(new User("Pavel", 26, "Cisco", "Ulyanovsk"));
        users.add(new User("Tatiana", 30, "Oracle", "Tula"));
        users.add(new User("Mikhail", 41, "Tesla", "Sochi"));
        users.add(new User("Elena", 24, "Adobe", "Vladivostok"));
        users.add(new User("Victor", 30, "NVIDIA", "Samara"));
        users.add(new User("Svetlana", 32, "Spotify", "Khabarovsk"));
        users.add(new User("Roman", 36, "Snapchat", "Tyumen"));
        users.add(new User("Yulia", 38, "LinkedIn", "Omsk"));
        users.add(new User("Denis", 23, "Zoom", "Irkutsk"));
        users.add(new User("Anastasia", 29, "Slack", "Kemerovo"));

        Map<Integer, List<User>> map = User.groupUsers(users);

        map.forEach((age, userList) ->
                System.out.println(age + ": " + userList));
    }
}
