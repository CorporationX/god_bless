package school.faang.bjs2_68230;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        User testUserOne = new User("Ivan", 18, "Google", "New York");
        log.info("testUserOne: {}", testUserOne);

        try {
            User testUserTwo = new User("", 18, "Google", "New York");
        } catch (IllegalArgumentException e) {
            log.error("testUserTwo: {}", e.toString());
        }

        try {
            User testUserThree = new User("Alex", 17, "Google", "New York");
        } catch (IllegalArgumentException e) {
            log.error("testUserThree: {}", e.toString());
        }

        try {
            User testUserFour = new User("Petr", 23, "VTB", "New York");
        } catch (IllegalArgumentException e) {
            log.error("testUserFour: {}", e.toString());
        }

        try {
            User testUserFive = new User("Pavel", 23, "Uber", "Moscow");
        } catch (IllegalArgumentException e) {
            log.error("testUserFive: {}", e.toString());
        }
    }
}
