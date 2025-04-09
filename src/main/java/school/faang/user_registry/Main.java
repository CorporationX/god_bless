package school.faang.user_registry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        checkUser("Alex", 20, "Google", "London");
        checkUser("", 20, "Google", "London");
        checkUser(null, 20, "Google", "London");
        checkUser("Alex", 10, "Google", "London");
        checkUser("Alex", 20, "Burger King", "London");
        checkUser("Alex", 20, "Google", "USA");

    }

    public static void checkUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            log.info("Пользователь {} был успешно создан", user);
        } catch (IllegalArgumentException e) {
            log.info("Ошибка при создании пользователя User(name={}, age={}, job={}, address={}): {}",
                    name, age, job, address, e.getMessage());
        }
    }

}
