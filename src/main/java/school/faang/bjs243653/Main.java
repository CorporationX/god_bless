package school.faang.bjs243653;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Sasha", 19, "Google", "Amsterdam");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
