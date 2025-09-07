package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("Ivan", 17, "Moscow", "ул. Пушкина, д. 10, кв. 5"),
                new User("Olga", 21, "Saint Petersburg", "Невский проспект, д. 12, кв. 34"),
                new User("Pavel", 30, "Kazan", "ул. Ленина, д. 7, кв. 21"),
                new User("Maria", 25, "Novosibirsk", "ул. Гагарина, д. 3, кв. 45"),
                new User("Svetlana", 28, "Yekaterinburg", "ул. Мира, д. 15, кв. 9"),
                new User("Alexey", 33, "Moscow", "ул. Садовая, д. 22, кв. 18"),
                new User("Anna", 19, "Saint Petersburg", "ул. Жукова, д. 5, кв. 11"),
                new User("Dmitry", 26, "Kazan", "ул. Космонавтов, д. 9, кв. 72"),
                new User("Nikolay", 41, "Novosibirsk", "ул. Тверская, д. 1, кв. 3"),
                new User("Elena", 23, "Yekaterinburg", "ул. Советская, д. 18, кв. 27"),
                new User("Oleg", 35, "Moscow", "ул. Пушкина, д. 24, кв. 66"),
                new User("Tatiana", 29, "Saint Petersburg", "Невский проспект, д. 30, кв. 12"),
                new User("Sergey", 31, "Kazan", "ул. Ленина, д. 44, кв. 8"),
                new User("Natalia", 22, "Novosibirsk", "ул. Гагарина, д. 2, кв. 97"),
                new User("Kirill", 27, "Yekaterinburg", "ул. Мира, д. 6, кв. 14"),
                new User("Irina", 24, "Moscow", "ул. Садовая, д. 11, кв. 53"),
                new User("Denis", 32, "Saint Petersburg", "ул. Жукова, д. 14, кв. 38"),
                new User("Viktoria", 20, "Kazan", "ул. Космонавтов, д. 8, кв. 41"),
                new User("Roman", 34, "Novosibirsk", "ул. Тверская, д. 19, кв. 22"),
                new User("Polina", 28, "Yekaterinburg", "ул. Советская, д. 27, кв. 75"),
                new User("Mikhail", 36, "Moscow", "ул. Пушкина, д. 13, кв. 7"),
                new User("Yulia", 21, "Saint Petersburg", "Невский проспект, д. 55, кв. 23"),
                new User("Andrey", 33, "Kazan", "ул. Ленина, д. 20, кв. 60"),
                new User("Alena", 25, "Novosibirsk", "ул. Гагарина, д. 16, кв. 4"),
                new User("Egor", 29, "Yekaterinburg", "ул. Мира, д. 28, кв. 88"),
                new User("Ksenia", 23, "Moscow", "ул. Садовая, д. 17, кв. 19"),
                new User("Artem", 27, "Saint Petersburg", "ул. Жукова, д. 26, кв. 31"),
                new User("Veronika", 24, "Kazan", "ул. Космонавтов, д. 33, кв. 20"),
                new User("Ilya", 30, "Novosibirsk", "ул. Тверская, д. 40, кв. 10"),
                new User("Marina", 26, "Yekaterinburg", "ул. Советская, д. 36, кв. 52"),
                new User("Vladimir", 42, "Moscow", "ул. Пушкина, д. 48, кв. 2"),
                new User("Ludmila", 37, "Saint Petersburg", "Невский проспект, д. 61, кв. 90"),
                new User("Timofey", 22, "Kazan", "ул. Ленина, д. 9, кв. 5"),
                new User("Alina", 28, "Novosibirsk", "ул. Гагарина, д. 29, кв. 77"),
                new User("Stepan", 31, "Yekaterinburg", "ул. Мира, д. 7, кв. 33"),
                new User("Zoya", 20, "Moscow", "ул. Садовая, д. 5, кв. 12"),
                new User("Mark", 27, "Saint Petersburg", "ул. Жукова, д. 18, кв. 55"),
                new User("Oksana", 24, "Kazan", "ул. Космонавтов, д. 21, кв. 46"),
                new User("Yaroslav", 35, "Novosibirsk", "ул. Тверская, д. 22, кв. 70"),
                new User("Inna", 23, "Yekaterinburg", "ул. Советская, д. 8, кв. 17")
        ));

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);
        System.out.println(usersByAge);
    }
}
