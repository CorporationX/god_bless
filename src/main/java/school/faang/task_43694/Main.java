package school.faang.task_43694;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Vanya", 18, "Google", "London");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
