package school.faang.registration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 23, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }
}