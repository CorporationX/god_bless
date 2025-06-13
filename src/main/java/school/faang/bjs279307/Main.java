package school.faang.bjs279307;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Vova", 29, "Amazon", "London");
            System.out.println("\nУспешно создан сотрудник: " + validUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
        }
        System.out.println(" ");
        try {
            User invalidUser = new User("Viktor", 28, "Microsoft", "California");
            System.out.println("Успешно создан сотрудник: " + invalidUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
        }
    }
}