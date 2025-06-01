package school.faang.bjs2_79158;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(5);
        users.add(new User("Иван", 33, "Сбербанк", "Москва"));
        users.add(new User("Минако", 24, "Studio Ghibli", "Токио"));
        users.add(new User("Анна", 29, "Яндекс", "Сочи"));
        users.add(new User("Такаши", 33, "Studio Ghibli", "Токио"));
        users.add(new User("ЛиЧханБин", 29, "Samsung", "Сеул"));

        System.out.println(User.groupUsers(users));
    }
}
