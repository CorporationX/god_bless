package school.faang;

import school.faang.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Вася", "Поваренок и К.О.", "ул. Пушкина", 11),
                new User("Петя", "Брауберг", "ул. Старушкина", 11),
                new User("Жора", "Кандибоберы", "аллея Петрушкина", 44),
                new User("Евгений", "Цирк", "мкр. 1", 65),
                new User("Ярик", "Казино", "мкр. 2", 9)
        );

        System.out.println(User.groupUsers(userList));
    }
}
