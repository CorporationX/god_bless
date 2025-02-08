package school.faang.sprint1.basicjava.userregistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Petr", 20, "Amazon", "London");
            System.out.println(user1);
            User user2 = new User("Olga", 30, "Google", "Moscow");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
