package school.faang.task_56587;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            User goodUser = new User("Anna", 22, "Google", "London");
            System.out.println(goodUser);
        } catch (IllegalArgumentException e) {
            log.info("Error creating user = {}", String.valueOf(e));
        }
    }
}
