package school.faang;

import school.faang.user_reg.User;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Alice", 25, "Google", "London");
            System.out.println("Успешно создан пользователь: " + validUser);
            System.out.println("HashCode: " + validUser.hashCode());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        testInvalidUser("", 30, "Amazon", "New York");
        testInvalidUser("Bob", 17, "Uber", "Amsterdam");
        testInvalidUser("Charlie", 20, "Microsoft", "Paris");
        testInvalidUser("Diana", 22, "Amazon", "Berlin");
        testInvalidUser(null, 25, "Google", "London");
    }

    private static void testInvalidUser(String name, int age, String job, String address) {
        try {
            User invalidUser = new User(name, age, job, address);
            System.out.println("Создан пользователь: " + invalidUser);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("\nПопытка создать пользователя с некорректными данными:");
            System.out.println("Параметры: name='" + name + "', age=" + age +
                    ", job='" + job + "', address='" + address + "'");
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
