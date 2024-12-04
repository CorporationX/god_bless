package school.faang.task_bjs43178;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new User("2222", 19, "Google", "London"));
        } catch (IllegalArgumentException e) {
            e.setStackTrace(e.getStackTrace());
        }
    }
}
