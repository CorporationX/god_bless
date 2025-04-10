package school.faang.bjs2_68375.user_registration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User user1 = createUser(1, "Vasilii", 18, "Google", "London");
        log.info("user1 = {}", user1);
        createUser(2, "", 18, "Google", "London");
        createUser(3, null, 18, "Google", "London");
        createUser(4, "Vasilii", 5, "Google", "London");
        createUser(5, "Vasilii", 22, "AMD", "London");
        createUser(6, "Vasilii", 22, "Google", "Moscow");
        createUser(7, "Vasilii", 22, null, "Moscow");
        createUser(8, "Vasilii", 22, "Google", null);
        createUser(9, null, 0, null, null);
        createUser(10, "Petr", 22, "Uber", "Amsterdam");
        createUser(11, "     ", 22, "Uber", "Amsterdam");
    }

    private static User createUser(int index, String name, int age, String job, String address) {
        User user = null;
        try {
            user = new User(name, age, job, address);
            log.info("user {} is added: {}", index, user);
        } catch (IllegalArgumentException e) {
            log.error("user {}  has not valid data: {}", index, e.getMessage());
        }
        return user;
    }
}
