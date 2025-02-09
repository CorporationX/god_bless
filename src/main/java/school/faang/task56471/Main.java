package school.faang.task56471;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Миша", 25, "Яндекс", "Москва"),
            new User("Саша", 30, "Аэрофлот", "Сочи"),
            new User("Рома", 18, "Пятёрочка", "Севастополь"),
            new User("Катя", 25, "Red Square", "Москва"),
            new User("Дима", 25, "Буханка", "Урюпинск"),
            new User("Ваня", 18, "Додо", "Дмитров")
        );
        System.out.println(User.groupUsers(users));
    }
}
