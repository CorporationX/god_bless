package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Вася", 23, "Сбербанк", "17a"));
        userList.add(new User("Петя", 12, "Яндекс", "154"));
        userList.add(new User("Дима", 23, "Сбербанк", "17a"));
        userList.add(new User("Коля", 11, "Тинькоф", "143г"));
        userList.add(new User("Света", 12, "Сбербанк", "17a"));

        System.out.println(User.groupUsers(userList));
    }


}
