package faang.school.godbless.BJS2_5188;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            User user = new User("Alex", 19, "Google", "London");
            System.out.println("All fields are correct");
        } catch (IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}