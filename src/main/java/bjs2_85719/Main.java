package bjs2_85719;

public class Main {
    public static void main(String[] args) {
        try {
            User u1 = new User("Alice", 25, "Google", "London");
            User u2 = new User("Bob", 30, "Amazon", "New York");

            System.out.println(u1);
            System.out.println(u2);

            // Ошибочный пример
            User u3 = new User("Eve", 17, "Uber", "Amsterdam");
            System.out.println(u3); // не выполнится

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания пользователя: " + e.getMessage());
        }
    }
}