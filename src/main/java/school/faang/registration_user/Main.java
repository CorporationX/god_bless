package school.faang.registration_user;

public class Main {

    private static User createUser(String name, Integer age, String job, String address) {
        return new User(name, age, job, address);
    }

    public static void main(String[] args) {
        System.out.println("=== Тестирование валидации User ===");

        System.out.println("\n1. Корректные данные:");
        try {
            User validUser = createUser("John Doe", 25, "Google", "London");
            System.out.println("[+] Успешно создан: " + validUser.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n2. Пустое имя:");
        try {
            User emptyName = createUser("", 25, "Uber", "New York");
            System.out.println("[+] Успешно создан: " + emptyName.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n3. Null имя:");
        try {
            User nullName = createUser(null, 25, "Amazon", "Amsterdam");
            System.out.println("[+] Успешно создан: " + nullName.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n4. Несовершеннолетний возраст:");
        try {
            User underage = createUser("Alice", 17, "Google", "London");
            System.out.println("[+] Успешно создан: " + underage.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n5. Null возраст:");
        try {
            User nullAge = createUser("Bob", null, "Uber", "New York");
            System.out.println("[+] Успешно создан: " + nullAge.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n6. Недопустимая работа:");
        try {
            User invalidJob = createUser("Charlie", 30, "Microsoft", "Amsterdam");
            System.out.println("[+] Успешно создан: " + invalidJob.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n7. Null работа:");
        try {
            User nullJob = createUser("Diana", 28, null, "London");
            System.out.println("[+] Успешно создан: " + nullJob.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n8. Недопустимый адрес:");
        try {
            User invalidAddress = createUser("Eve", 35, "Amazon", "Paris");
            System.out.println("[+] Успешно создан: " + invalidAddress.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n9. Null адрес:");
        try {
            User nullAddress = createUser("Frank", 40, "Uber", null);
            System.out.println("[+] Успешно создан: " + nullAddress.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n10. Множественные ошибки:");
        try {
            User multipleErrors = createUser("", 16, "InvalidJob", "InvalidCity");
            System.out.println("[+] Успешно создан: " + multipleErrors.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Тестирование завершено ===");
    }
}
