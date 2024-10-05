package tasks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsersList();
        System.out.println("Список пользователей");
        User.showUsers(users);
        System.out.println("Коллекция пользователей сгруппированная по возрасту");
        User.showUsersSortedByAge(User.groupUser(users));
    }

    public static List<User> getUsersList() {
        return List.of(
                new User("Алексей", 30, "Яндекс", "г. Москва, ул. Ленина, д. 10"),
                new User("Дмитрий", 18, "Роснефть", "г. Казань, ул. Баумана, д. 12"),
                new User("Мария", 30, "Сбербанк", "г. Санкт-Петербург, Невский пр., д. 25"),
                new User("Екатерина", 22, "Лукойл", "г. Новосибирск, ул. Ленина, д. 5"),
                new User("Иван", 32, "Газпром", "г. Екатеринбург, проспект Ленина, д. 20"),
                new User("Ольга", 30, "РЖД", "г. Нижний Новгород, ул. Горького, д. 8"),
                new User("Сергей", 19, "МТС", "г. Самара, ул. Куйбышева, д. 18"),
                new User("Анна", 55, "Билайн", "г. Ростов-на-Дону, ул. Советская, д. 11"),
                new User("Николай", 20, "Мегафон", "г. Челябинск, проспект Победы, д. 4"),
                new User("Вера", 32, "Тинькофф", "г. Омск, ул. Гагарина, д. 15")
        );
    }
}
