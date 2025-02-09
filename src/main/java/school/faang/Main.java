package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            User firstUser = new User("Mike", 28, "Google", "London");
            System.out.println(firstUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User secondUser = new User("Mikhail", 35, "T-Systems", "New York");
            System.out.println(secondUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
