package school.faang.registration;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Vitaly Mikhaylov", 31, "Google", "London");
            System.out.println(user1);

            User user2 = new User(" ", 17, "Yandex", "Madrid");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}