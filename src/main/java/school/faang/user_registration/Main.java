package school.faang.user_registration;

public class Main {

    public static void main(String[] args) {
        try {
            User user1 = new User("Alice", 25, "Google", "London");
            System.out.println("Успешно: " + user1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            User user2 = new User("", 22, "Uber", "New York"); // пустое имя
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            User user3 = new User("Bob", 17, "Amazon", "Amsterdam"); // возраст < 18
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            User user4 = new User("Charlie", 30, "Microsoft", "London"); // недопустимая работа
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            User user5 = new User("Dana", 28, "Google", "Tokyo"); // недопустимый город
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
