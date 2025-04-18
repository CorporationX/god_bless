package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Вадим Шаталов", 21, "Google", "London");
            System.out.println("Пользователь создан: " + user1.getName());

            User user2 = new User("Иван Зубило", 15, "Microsoft", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
