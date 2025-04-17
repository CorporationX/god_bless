package school.faang.bjs2_69409;

import java.util.Arrays;

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
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }
}