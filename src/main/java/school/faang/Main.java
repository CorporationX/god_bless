package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 25, "Google", "London");
            System.out.println("Пользователь создан: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }

        try {
            User invalidUser = new User("", 17, "Facebook", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
