package school.faang.task_43777;

public class Main {
    public static void main(String[] args) {
        UserFactory.createUsers().forEach(System.out::println);

        try {
            new User("Alice", 17, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.err.println("User creation error: " + e.getMessage());
        }
    }
}