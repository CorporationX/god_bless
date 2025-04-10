package school.faang.bjs2_68261;

import java.util.List;

/**
 * Задача "Группировка пользователей по возрасту"
 */
public class Main {
    public static void main(String[] args) {
        var users = List.of(
                new User("Дима", 13, "Школьник", "г Москва"),
                new User("Вася", 40, "Какая-то важная контора", "г Санкт-Петербург"),
                new User("Игорь", 40, "Какое-то главное управление", "г Екатеринбург"),
                new User("Миша", 27, "Сидит у мамки на шее", "г Владивосток"),
                new User("Таня", 13, "Такая же школота, как и Дима", "г Мурманск"),
                new User("Оля", 27, "Коуч всего на свете в инстаграме", "г Новосибирск"),
                new User("Оля", 60, "На пенсии", "г Благовещенск")
        );

        System.out.println(User.groupUsers(users));

    }
}
