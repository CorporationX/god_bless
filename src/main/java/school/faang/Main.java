package school.faang;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        // Проверим работу метода на списке пользователей.
        List<User> usersList = List.of(
                new User("John", 25, "Google",
                        "America"),
                new User("God", 2024, "Heaven",
                        "World"),
                new User("Satan", 2024, "Hell",
                        "World"),
                new User("Piper", 25, "Orchestra",
                        "China"),
                new User("Bobby", 25, "Google",
                        "UK")
        );

        System.out.println(User.groupUsers(usersList));
    }
}
