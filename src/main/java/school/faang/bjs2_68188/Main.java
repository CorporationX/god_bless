package school.faang.bjs2_68188;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Max", 19, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
