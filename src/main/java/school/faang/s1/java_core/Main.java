package school.faang.s1.java_core;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Greg", 25, "Google", "London");
            System.out.println("Пользователь создан: " + user1.getName());

            // Некорректные данные
            User user2 = new User("Gary", 17, "Amazon", "Amsterdam");
            User user3 = new User("Gary", 19, "AmazIn", "Amsterdam");
            User user4 = new User("Gary", 19, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
