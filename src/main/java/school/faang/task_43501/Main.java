package school.faang.task_43501;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Ksusha", 20, "Google", "Minsk");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
