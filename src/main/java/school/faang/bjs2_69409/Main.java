package school.faang.bjs2_69409;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String [] args) {
        try {
            var users = Arrays.asList(
                    new User("Нормес", 19, "Uber", "Amsterdam"),
                    new User("Чипсон", 23, "Ларек", "New York"),
                    new User("Терпила", 54, "Amazon", "New York"),
                    new User("Красавела", 37, "Там", "Uspensk"),
                    new User("Кадыров", 48, "Google", "London")
            );
        } catch (IllegalArgumentException ex) {
            log.error("Exception occurred: {}", ex.getMessage(), ex);
        }
    }
}