package school.faang.sprintone.userregistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 25, "Google", "London");
            System.out.printf("Пользователь успешно создан: %s \n", user);
        } catch (IllegalArgumentException e) {
            printError(e);
        }

        try {
            User invalidUser = new User("", 25, "Google", "London");
        } catch (IllegalArgumentException e) {
            printError(e);
        }

        try {
            User anotherInvalidUser = new User("Bob", 17, "Uber", "London");
        } catch (IllegalArgumentException e) {
            printError(e);
        }

        try {
            User yetAnotherInvalidUser = new User("Charlie", 25, "UnknownJob", "London");
        } catch (IllegalArgumentException e) {
            printError(e);
        }

        try {
            User finalInvalidUser = new User("David", 25, "Google", "UnknownAddress");
        } catch (IllegalArgumentException e) {
            printError(e);
        }
    }

    public static void printError(IllegalArgumentException ex) {
        System.err.printf("Ошибка при создании пользователя: %s\n", ex.getMessage());
    }
}