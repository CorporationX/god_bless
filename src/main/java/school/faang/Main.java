package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<User> users = List.of(new User("Павел", 31, "yandex", "Moscow"),
                new User("Семен", 12, "yandex", "Orlov"),
                new User("Антон", 75, "yandex", "Krasnodar"),
                new User("Иван", 12, "yandex", "Adler"),
                new User("Николай", 57, "yandex", "Moscow"));

        System.out.println(User.groupUsers(users));


    }
}
