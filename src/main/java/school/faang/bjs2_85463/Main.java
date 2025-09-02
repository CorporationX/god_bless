package school.faang.bjs2_85463;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> user = List.of(
                new User("Анна", 25, "Google", "Москва"),
                new User("Иван", 30, "Яндекс", "Санкт-Петербург"),
                new User("Мария", 25, "Microsoft", "Казань"),
                new User("Алексей", 25, "Apple", "Новосибирск"),
                new User("Екатерина", 30, "Amazon", "Екатеринбург")
        );
        System.out.println(User.groupUsers(user));
    }
}
