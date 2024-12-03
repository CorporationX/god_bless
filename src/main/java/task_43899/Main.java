package task_43899;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("Кирил", 20, "Дворник", "Ярославль"));
        listUsers.add(new User("Влад", 21, "Сантехник", "Тверь"));
        listUsers.add(new User("Саша", 20, "Безработный", "Москва"));
        listUsers.add(new User("Паша", 23, "Водитель", "Владимир"));
        listUsers.add(new User("Вика", 20, "Косметолог", "Калуга"));
        listUsers.add(new User("Юля", 21, "Кондитер", "Томбов"));

        User.groupUsers(listUsers);
        User.printUsers(User.enterAge());
    }
}
