package school.faang;

public class Main {
    public static void main(String[] args) {
        User validUser = createUser("Вадим Шталов", 21, "Google", "New York");
        if (validUser != null) {
            System.out.println("Пользователь создан: " + validUser);
        }

        User invalidUser = createUser("", 17, "Microsoft", "Paris");
        if (invalidUser == null) {
            System.out.println("Не удалось создать пользователя");
        }
    }

    private static User createUser(String name, int age, String job, String address) {
        try {
            return new User(name, age, job, address);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
            return null;
        }
    }
}



