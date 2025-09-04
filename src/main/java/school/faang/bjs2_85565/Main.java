package school.faang.bjs2_85565;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alexey", 20, "Google", "London");
            User user2 = new User("Anna", 25, "Amazon", "New York");
            User user3 = new User("Ivan", 17, "Uber", "Amsterdam"); // Ошибка

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
