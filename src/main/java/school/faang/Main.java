package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alex", 25, "Google", "Chicago");
            System.out.println(user1);

            User user2 = new User("", 17, "Yandex", "Moscow");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake: " + e.getMessage());
        }
    }
}
