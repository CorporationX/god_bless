package school.faang;

import school.faang.service.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User vasya = new User("Вася", 33, "Футбол,Рыбалка");
        User petya = new User("Петя", 28, "Волейбол,Рыбалка");
        User irina = new User("Ирина", 25, "Волейбол,Вышивание");
        User dima = new User("Петя", 28, "Футбол, Программирование");

        users.add(vasya);
        users.add(petya);
        users.add(irina);
        users.add(dima);
    }
}

