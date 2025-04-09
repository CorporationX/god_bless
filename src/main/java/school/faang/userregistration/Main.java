package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 25, "Google", "London");
            System.out.println("Пользователь успешно создан: " + user);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User invalidUser = new User("", 25, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User anotherInvalidUser = new User("Bob", 17, "Uber", "London");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User yetAnotherInvalidUser = new User("Charlie", 25, "UnknownJob", "London");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User finalInvalidUser = new User("David", 25, "Google", "UnknownAddress");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}