package school.faang.task43662;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("elnur", 22, "Google", "Amsterdam");

            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка создания пользователя: " + e.getMessage());
        }
    }
}