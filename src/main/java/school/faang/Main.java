package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

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
            logger.log(Level.SEVERE, "Ошибка при ожидании завершения потоков", e);
        }

        logger.info("Все игроки завершили свои действия.");
    }
}

