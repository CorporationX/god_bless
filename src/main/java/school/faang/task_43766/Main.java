package school.faang.task_43766;

public class Main {
    public static void main(String[] args) {
        User user1;
        try {
            user1 = new User("Tom", 18, "Google", "London");
            System.out.println(user1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
