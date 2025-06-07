package school.faang.bjs2_79272;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Dominic", 30, "Google", "London");
            System.out.println("пользователь создан " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошиька " + e.getMessage());
        }
        try {
            User user = new User("Bob", 16, "Amazon", "New York");
            System.out.println("Пользователь создан: " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            User user = new User("Charlie", 30, "Facebook", "Amsterdam");
            System.out.println("пользователь создан " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            User user = new User("Diana", 28, "Uber", "Berlin");
            System.out.println("пользователь создан " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
