package faang.school.godbless.javacore.taskvalid;


public class Main {
    public static void main(String[] args) {

        User validUser = new User("John Doe", 25, "Google", "London");
        System.out.println("Пользователь создан успешно.");

        try {
            User invalidNameUser = new User(null, 30, "Uber", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User invalidAgeUser = new User("Alice", 15, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User invalidJobUser = new User("Bob", 28, "Microsoft", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User invalidAddressUser = new User("Eve", 22, "Uber", "Tokyo");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}

