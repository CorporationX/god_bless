package faang.school.godbless.javaCore.groupUsersByAge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Вася", 25, "Google", "город, улица, дом"));
        users.add(new User("Петя", 27, "Yandex", "город, улица, дом"));
        users.add(new User("Катя", 25, "Amazon", "город, улица, дом"));
        users.add(new User("Лиза", 28, "Uber", "город, улица, дом"));
        users.add(new User("Костя", 28, "Apple", "город, улица, дом"));
        users.add(new User("Коля", 25, "Meta", "город, улица, дом"));

        System.out.println(User.groupUsers(users));
    }
}
