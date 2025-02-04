package school.faang;

import school.faang.service.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User vasya = new User("Василий", 35, "Больница", "Санаторная 29");
        User petya = new User("Петр", 41, "Завод", "Промышленная 1а");
        User dima = new User("Дмитрий", 41, "Faang school", "Гиковская 99/2");
        User sveta = new User("Светлана", 33, "Аэрофлот", "Самолетная 4");

        List<User> users = new ArrayList<>(List.of(vasya, petya, dima, sveta));
        for (Map.Entry<Integer, List<User>> value : User.groupUsers(users).entrySet())
            for (int i = 0; i < value.getValue().size(); i++) {
                System.out.println(value.getKey() + " " + value.getValue().get(i).getName());
            }
    }
}
