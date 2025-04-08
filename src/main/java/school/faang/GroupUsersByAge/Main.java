package school.faang.GroupUsersByAge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .name("Иван")
                .age(25)
                .jobName("Инженер")
                .address("Москва")
                .build());

        users.add(User.builder()
                .name("Петр")
                .age(25)
                .jobName("Программист")
                .address("Санкт-Петербург")
                .build());

        users.add(User.builder()
                .name("Мария")
                .age(25)
                .jobName("Менеджер")
                .address("Киев")
                .build());

        users.add(User.builder()
                .name("Алексей")
                .age(32)
                .jobName("Бухгалтер")
                .address("Лондон")
                .build());

        users.add(User.builder()
                .name("Елена")
                .age(32)
                .jobName("Врач")
                .address("Париж")
                .build());

        users.add(User.builder()
                .name("Дмитрий")
                .age(32)
                .jobName("Юрист")
                .address("Берлин")
                .build());

        users.add(User.builder()
                .name("Наталья")
                .age(29)
                .jobName("Психолог")
                .address("Рим")
                .build());

        users.add(User.builder()
                .name("Сергей")
                .age(38)
                .jobName("Экономист")
                .address("Мадрид")
                .build());

        users.add(User.builder()
                .name("Анастасия")
                .age(38)
                .jobName("Дизайнер")
                .address("Амстердам")
                .build());

        users.add(User.builder()
                .name("Владимир")
                .age(40)
                .jobName("Маркетолог")
                .address("Вена")
                .build());

        System.out.println(User.groupUsers(users));
    }
}
