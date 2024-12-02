package school.module1.task43685;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Semyon", 31, "Google", "Amsterdam");
            System.out.println(user.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
