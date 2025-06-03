package school.faang.bjs2_79204;

public class Main {
    public static void main(String[] args) {
        createUser("Alice", 25, "Google", "London");
        createUser("Bob", 19, "Amazon", "New York");
        createUser("Charlie", 30, "Google", "Amsterdam");
        createUser("Jek", 30, "Uber", "London");
        createUser("Dana", 28, "Amazon", "New York");
    }

    private static void createUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println("Создан пользователь: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}