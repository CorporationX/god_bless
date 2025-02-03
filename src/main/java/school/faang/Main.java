package school.faang;

import school.faang.service.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Set<String> hobbies = new HashSet<>();

        //список хобби на поиск
        hobbies.add("Футбол");
        hobbies.add("Вышивание");

        User vasya = new User("Вася", 33, new HashSet<>(Arrays.asList("Футбол", "Рыбалка")));
        User petya = new User("Петя", 28, new HashSet<>(Arrays.asList("Волейбол", "Рыбалка")));
        User irina = new User("Ирина", 25, new HashSet<>(Arrays.asList("Волейбол", "Вышивание")));
        User dima = new User("Дима", 28, new HashSet<>(Arrays.asList("Хоккей", "Программирование")));

        users.add(vasya);
        users.add(petya);
        users.add(irina);
        users.add(dima);
        User.findHobbyLovers(users, hobbies);
    }
}

