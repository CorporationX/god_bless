package faang.school.godbless.users_registration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        User user1 = new User("Test1", 18, "Google", "London"); // valid user

        try {
            User user2 = new User("Test1", 17, "Google", "London"); // invalid user
        } catch (IllegalArgumentException e) {
            log.info("everything_works_correctly");
        }

        try {
            User user3 = new User("Test1", 18, "Yandex", "London"); // invalid user
        } catch (IllegalArgumentException e) {
            log.info("everything_works_correctly");
        }

        try {
            User user4 = new User("Test1", 18, "Google", "Moscow"); // invalid user
        } catch (IllegalArgumentException e) {
            log.info("everything_works_correctly");
        }

    }

}
