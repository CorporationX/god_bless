package school.faang.registration;

public class Main {
    public static void main(String[] args) {

        try {
            User user1 = new User("Антон", 45, "Uzum", "Novosibirsk");
            User user2 = new User("Петя", 20, "Uber", "Amsterdam");
            User user3 = new User("Саша", 15, "Uber", "Novosibirsk");
        } catch (IllegalArgumentException e) {
            System.out.printf("Ошибка при создании пользователя: %s", e.getMessage());
        }
    }
}