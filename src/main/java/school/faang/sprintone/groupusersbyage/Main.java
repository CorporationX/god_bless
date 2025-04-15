package school.faang.sprintone.groupusersbyage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                User.builder()
                        .name("Iван")
                        .age(25)
                        .jobName("Iнженер")
                        .address("Москва")
                        .build(),
                User.builder()
                        .name("Петр")
                        .age(25)
                        .jobName("Программист")
                        .address("Санкт-Петербург")
                        .build(),
                User.builder()
                        .name("Мария")
                        .age(25)
                        .jobName("Менеджер")
                        .address("Киев")
                        .build(),
                User.builder()
                        .name("Алексей")
                        .age(32)
                        .jobName("Бухгалтер")
                        .address("Лондон")
                        .build(),
                User.builder()
                        .name("Елена")
                        .age(32)
                        .jobName("Врач")
                        .address("Париж")
                        .build(),
                User.builder()
                        .name("Дмитрий")
                        .age(32)
                        .jobName("Юрист")
                        .address("Берлин")
                        .build(),
                User.builder()
                        .name("Наталья")
                        .age(29)
                        .jobName("Психолог")
                        .address("Рим")
                        .build(),
                User.builder()
                        .name("Сергей")
                        .age(38)
                        .jobName("Экономист")
                        .address("Мадрид")
                        .build(),
                User.builder()
                        .name("Анастасия")
                        .age(38)
                        .jobName("Дизайнер")
                        .address("Амстердам")
                        .build(),
                User.builder()
                        .name("Владимир")
                        .age(40)
                        .jobName("Маркетолог")
                        .address("Вена")
                        .build()
        );

        System.out.println(User.groupUsers(users));
    }
}
