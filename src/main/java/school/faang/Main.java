package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Tom", 18, "Google", "London");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
