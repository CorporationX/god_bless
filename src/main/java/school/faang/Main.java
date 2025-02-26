package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("Лорд");
        roles.add("Рыцарь");
        roles.add("Маг");

        House house = new House(roles);

        User userFirst = new User("Игрок 1");
        User userSecond = new User("Игрок 2");
        User userThirst = new User("Игрок 3");

        userFirst.start();
        userSecond.start();
        userThirst.start();

        try {
            userFirst.join();
            userSecond.join();
            userThirst.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все игроки завершили свои действия.");
    }
}

